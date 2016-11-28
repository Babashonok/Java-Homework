package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet that manage GET_POST requests
 */
public class ManagePersonServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	/**
	 * manage duplicate pieces of code
	 * @param request
	 * @param jsp_parameters
	 * @param error_message
	 * @param editable_person
	 * @param editable_phone
	 */
	private void duplicateCode(HttpServletRequest request, HashMap<String, String> jsp_parameters,
							   String error_message, Person editable_person, String editable_phone) {

		jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
		jsp_parameters.put("current_action_result_label", "Ошибка обновления");


		jsp_parameters.put("current_action", "add_phone");
		jsp_parameters.put("next_action", "add_phone_go");
		jsp_parameters.put("next_action_label", "Сохранить");
		jsp_parameters.put("error_message", error_message);

		request.setAttribute("person", editable_person);
		request.setAttribute("phone", editable_phone);
		request.setAttribute("jsp_parameters", jsp_parameters);
	}


	private Phonebook phonebook;

	/**
	 * constructor that calls parent constructor
	 * and initializes singleton object phonebook
	 */
	public ManagePersonServlet() {
		super();
		try {
			this.phonebook = Phonebook.getInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * validate FIO of testing person
	 * create error message if one of the field has invalid value
	 *
	 * @param person testing person
	 * @return possible error message
	 */
	private String validatePersonFMLName(Person person) {
		String error_message = "";

		if (!person.validateFMLNamePart(person.getName(), false)) {
			error_message += "Имя должно быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
		}

		if (!person.validateFMLNamePart(person.getSurname(), false)) {
			error_message += "Фамилия должна быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
		}

		if (!person.validateFMLNamePart(person.getMiddlename(), true)) {
			error_message += "Отчество должно быть строкой от 0 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
		}
		return error_message;
	}

	/**
	 * validate phone number
	 * create error message if it has invalid value
	 *
	 * @param phone
	 * @return possible error message
	 */
	private String validatePhoneNumber(String phone) {
		String error_message = "";
		if (phone == null) {
			return error_message;
		}
		Matcher matcher = Pattern.compile("[0-9#+-]{2,50}").matcher(phone);
		if (!matcher.matches()) {
			error_message += "Номер должен содержать от 2 до 50 символов и состоять из цифр, \"-\", \"+\", \"#\".<br />";
		}
		return error_message;
	}

	/**
	 * manage Get requests in the HTTP Servlets
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Обязательно ДО обращения к любому параметру нужно переключиться в UTF-8,
		// иначе русский язык при передаче GET/POST-параметрами превращается в "кракозябры".
		request.setCharacterEncoding("UTF-8");

		// В JSP нам понадобится сама телефонная книга. Можно создать её экземпляр там,
		// но с архитектурной точки зрения логичнее создать его в сервлете и передать в JSP.
		request.setAttribute("phonebook", this.phonebook);

		// Хранилище параметров для передачи в JSP.
		HashMap<String, String> jsp_parameters = new HashMap<String, String>();

		// Диспетчеры для передачи управления на разные JSP (разные представления (view)).
		RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
		RequestDispatcher dispatcher_for_phone = request.getRequestDispatcher("/ManagePhone.jsp");
		RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");

		// Действие (action) и идентификатор записи (id) над которой выполняется это действие.
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String phone_id = request.getParameter("phone_id");

		Person editable_person;
		HashMap<String, String> phones;

		// Если идентификатор и действие не указаны, мы находимся в состоянии
		// "просто показать список и больше ничего не делать".
		if ((action == null) && (id == null)) {
			request.setAttribute("jsp_parameters", jsp_parameters);
			dispatcher_for_list.forward(request, response);
		} else {
			switch (action) {
				// Добавление записи.
				case "add":
					// Создание новой пустой записи о пользователе.
					Person empty_person = new Person();

					// Подготовка параметров для JSP.
					jsp_parameters.put("current_action", "add");
					jsp_parameters.put("next_action", "add_go");
					jsp_parameters.put("next_action_label", "Добавить");

					// Установка параметров JSP.
					request.setAttribute("person", empty_person);
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_manager.forward(request, response);
					break;

				// Редактирование записи.
				case "edit":
					// Извлечение из телефонной книги информации о редактируемой записи.
					editable_person = this.phonebook.getPerson(id);

					// Подготовка параметров для JSP.
					jsp_parameters.put("current_action", "edit");
					jsp_parameters.put("next_action", "edit_go");
					jsp_parameters.put("next_action_label", "Сохранить");

					// Установка параметров JSP.
					request.setAttribute("person", editable_person);
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_manager.forward(request, response);
					break;
				// Удаление записи.
				case "delete":

					// Если запись удалось удалить...
					if (phonebook.deletePerson(id)) {
						jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
						jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
					}
					// Если запись не удалось удалить (например, такой записи нет)...
					else {
						jsp_parameters.put("current_action_result", "DELETION_FAILURE");
						jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
					}

					// Установка параметров JSP.
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_list.forward(request, response);
					break;

				case "add_phone":
					editable_person = this.phonebook.getPerson(id);
					String new_phone = "";

					// Подготовка параметров для JSP.
					jsp_parameters.put("current_action", "add_phone");
					jsp_parameters.put("next_action", "add_phone_go");
					jsp_parameters.put("next_action_label", "Добавить номер");

					// Установка параметров JSP.
					request.setAttribute("person", editable_person);
					request.setAttribute("phone", new_phone);
					request.setAttribute("phone_id", phone_id);
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_phone.forward(request, response);
					break;

				case "edit_phone":
					editable_person = this.phonebook.getPerson(id);

					phones = editable_person.getPhones();
					String editable_phone = phones.get(phone_id);

					// Подготовка параметров для JSP.
					jsp_parameters.put("current_action", "edit_phone");
					jsp_parameters.put("next_action", "edit_phone_go");
					jsp_parameters.put("next_action_label", "Сохранить номер");

					// Установка параметров JSP.
					request.setAttribute("person", editable_person);
					request.setAttribute("phone", editable_phone);
					request.setAttribute("phone_id", phone_id);
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_phone.forward(request, response);
					break;

				case "delete_phone":
					editable_person = this.phonebook.getPerson(id);

					phones = editable_person.getPhones();
					phones.remove(phone_id);
					this.phonebook.deletePhone(editable_person, phone_id);

					// Подготовка параметров для JSP.
					jsp_parameters.put("current_action", "edit");
					jsp_parameters.put("next_action", "edit_go");
					jsp_parameters.put("next_action_label", "Сохранить номер");

					// Установка параметров JSP.
					request.setAttribute("person", editable_person);
					request.setAttribute("jsp_parameters", jsp_parameters);

					// Передача запроса в JSP.
					dispatcher_for_manager.forward(request, response);
					break;

			}
		}

	}

	/**
	 * manage Post requests in the HTTP Servlets
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Обязательно ДО обращения к любому параметру нужно переключиться в UTF-8,
		// иначе русский язык при передаче GET/POST-параметрами превращается в "кракозябры".
		request.setCharacterEncoding("UTF-8");

		// В JSP нам понадобится сама телефонная книга. Можно создать её экземпляр там,
		// но с архитектурной точки зрения логичнее создать его в сервлете и передать в JSP.
		request.setAttribute("phonebook", this.phonebook);

		// Хранилище параметров для передачи в JSP.
		HashMap<String, String> jsp_parameters = new HashMap<String, String>();

		// Диспетчеры для передачи управления на разные JSP (разные представления (view)).
		RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
		RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
		RequestDispatcher dispatcher_for_phone = request.getRequestDispatcher("/ManagePhone.jsp");


		// Действие (add_go, edit_go) и идентификатор записи (id) над которой выполняется это действие.
		String add_go = request.getParameter("add_go");
		String edit_go = request.getParameter("edit_go");
		String edit_phone_go = request.getParameter("edit_phone_go");
		String add_phone_go = request.getParameter("add_phone_go");
		String id = request.getParameter("id");
		String phone_id = request.getParameter("phone_id");

		// Добавление записи.
		if (add_go != null) {
			// Создание записи на основе данных из формы.
			Person new_person = new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("middlename"));
			// Валидация ФИО.
			String error_message = this.validatePersonFMLName(new_person);
			// Если данные верные, можно производить добавление.
			if (error_message.equals("")) {
				// Если запись удалось добавить...
				if (this.phonebook.addPerson(new_person)) {
					jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
					jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
				} else {
					jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
					jsp_parameters.put("current_action_result_label", "Ошибка добавления");
				}
				// Установка параметров JSP.
				request.setAttribute("jsp_parameters", jsp_parameters);
				// Передача запроса в JSP.
				dispatcher_for_list.forward(request, response);
			}
			// Если в данных были ошибки, надо заново показать форму и сообщить об ошибках.
			else {
				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "add");
				jsp_parameters.put("next_action", "add_go");
				jsp_parameters.put("next_action_label", "Добавить");
				jsp_parameters.put("error_message", error_message);

				// Установка параметров JSP.
				request.setAttribute("person", new_person);
				request.setAttribute("jsp_parameters", jsp_parameters);

				// Передача запроса в JSP.
				dispatcher_for_manager.forward(request, response);
			}
		}

		// Редактирование записи.
		if (edit_go != null) {
			// Получение записи и её обновление на основе данных из формы.
			Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
			updatable_person.setName(request.getParameter("name"));
			updatable_person.setSurname(request.getParameter("surname"));
			updatable_person.setMiddlename(request.getParameter("middlename"));

			// Валидация ФИО.
			String error_message = this.validatePersonFMLName(updatable_person);

			// Если данные верные, можно производить добавление.
			if (error_message.equals("")) {

				// Если запись удалось обновить...
				if (this.phonebook.updatePerson(id, updatable_person)) {
					jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
					jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
				}
				// Если запись НЕ удалось обновить...
				else {
					jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
					jsp_parameters.put("current_action_result_label", "Ошибка обновления");
				}

				// Установка параметров JSP.
				request.setAttribute("jsp_parameters", jsp_parameters);

				// Передача запроса в JSP.
				dispatcher_for_list.forward(request, response);
			}
			// Если в данных были ошибки, надо заново показать форму и сообщить об ошибках.
			else {

				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "edit");
				jsp_parameters.put("next_action", "edit_go");
				jsp_parameters.put("next_action_label", "Сохранить");
				jsp_parameters.put("error_message", error_message);

				// Установка параметров JSP.
				request.setAttribute("person", updatable_person);
				request.setAttribute("jsp_parameters", jsp_parameters);

				// Передача запроса в JSP.
				dispatcher_for_manager.forward(request, response);
			}
		}

		if (add_phone_go != null) {
			Person editable_person = this.phonebook.getPerson(id);
			HashMap<String, String> phones = editable_person.getPhones();
			String editable_phone = request.getParameter("phone");

			String error_message = this.validatePhoneNumber(editable_phone);

			if (error_message.equals("")) {
				phones.put(phone_id, editable_phone);
				if (this.phonebook.addPhone(editable_person,editable_phone)) {
					jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
					jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
				} else {
					jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
					jsp_parameters.put("current_action_result_label", "Ошибка обновления");
				}

				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "edit");
				jsp_parameters.put("next_action", "edit_go");
				jsp_parameters.put("next_action_label", "Сохранить");

				// Установка параметров JSP.
				request.setAttribute("person", editable_person);
				request.setAttribute("jsp_parameters", jsp_parameters);

				// Передача запроса в JSP.
				dispatcher_for_manager.forward(request, response);
			} else {
				duplicateCode(request,jsp_parameters,error_message,editable_person,editable_phone);

				// Передача запроса в JSP.
				dispatcher_for_phone.forward(request, response);
			}
		}

		if (edit_phone_go != null) {
			Person editable_person = this.phonebook.getPerson(id);
			HashMap<String, String> phones = editable_person.getPhones();
			String editable_phone = request.getParameter("phone");
			String error_message = this.validatePhoneNumber(editable_phone);

			if (error_message.equals("")) {
				phones.put(phone_id, editable_phone);

				// Если запись удалось обновить...
				if (this.phonebook.editPhone(editable_person, editable_phone, phone_id )) {
					jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
					jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
				} else {
					jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
					jsp_parameters.put("current_action_result_label", "Ошибка обновления");
				}

				// Рисуем обратно редактирование пользователя

				// Подготовка параметров для JSP.
				jsp_parameters.put("current_action", "edit");
				jsp_parameters.put("next_action", "edit_go");
				jsp_parameters.put("next_action_label", "Сохранить");

				// Установка параметров JSP.
				request.setAttribute("person", editable_person);
				request.setAttribute("jsp_parameters", jsp_parameters);

				// Передача запроса в JSP.
				dispatcher_for_manager.forward(request, response);
			} else {
				duplicateCode(request,jsp_parameters,error_message,editable_person,editable_phone);
				// Передача запроса в JSP.
				dispatcher_for_phone.forward(request, response);
			}
		}
	}
}
