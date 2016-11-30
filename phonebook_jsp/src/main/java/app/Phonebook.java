package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import util.DBWorker;

/**
 * create Singleton object of this class
 */
public class Phonebook {


	private HashMap<String,Person> persons = new HashMap<String,Person>();
	

	private DBWorker db = DBWorker.getInstance();
	

	private static Phonebook instance = null;

	/**
	 * Singleton pattern realization
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Phonebook getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
	         instance = new Phonebook();
	    }
		return instance;
	}

	/**
	 * create single object of the phonebook
	 * read person list from the database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected Phonebook() throws ClassNotFoundException, SQLException {
		ResultSet db_data = this.db.getDBData("SELECT * FROM `person` ORDER BY `surname` ASC");
		while (db_data.next()) {
			this.persons.put(db_data.getString("id"), new Person(db_data.getString("id"), db_data.getString("name"), db_data.getString("surname"), db_data.getString("middlename")));
		}
	}

	/**
	 * add persom to the database
	 * @param person
	 * @return
	 */
	public boolean addPerson(Person person)	{

		String query;
		// У человека может не быть отчества.
		if (!person.getSurname().equals("")) {
			query = "INSERT INTO `person` (`name`, `surname`, `middlename`) VALUES ('" + person.getName() +"', '" + person.getSurname() +"', '" + person.getMiddlename() + "')";
		} else {
			query = "INSERT INTO `person` (`name`, `surname`) VALUES ('" + person.getName() +"', '" + person.getSurname() +"')";
		}
		Integer affected_rows = this.db.changeDBData(query);
		if (affected_rows > 0) {
			person.setId(this.db.getLastInsertId().toString());
			this.persons.put(person.getId(), person);
			return true;
		} else {
			return false;
		}
	}


	/**
	 * update info about chosen person in the database
	 * @param id
	 * @param person
	 * @return
	 */
	public boolean updatePerson(String id, Person person) {
		Integer id_filtered = Integer.parseInt(person.getId());
		String query = "";


		if (!person.getSurname().equals("")) {
			query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "', `middlename` = '" + person.getMiddlename() + "' WHERE `id` = " + id_filtered;
		} else {
			query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "' WHERE `id` = " + id_filtered;
		}
		Integer affected_rows = this.db.changeDBData(query);
		if (affected_rows > 0) {
			this.persons.put(person.getId(), person);
			return true;
		} else {
			return false;
		}
	}


	/**
	 * delete chosen person from the database
	 * @param id
	 * @return
	 */
	public boolean deletePerson(String id) {
		if ((id != null)&&(!id.equals("null"))) {
			int filtered_id = Integer.parseInt(id);
			Integer affected_rows = this.db.changeDBData("DELETE FROM `person` WHERE `id`=" + filtered_id);
			if (affected_rows > 0) {
				this.persons.remove(id);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * add phone to the database
	 * @param person
	 * @param number
	 * @return
	 */
	public boolean addPhone(Person person, String number) {
		String query = "INSERT INTO `phone` (`owner`, `number`) VALUES ('" + person.getId() +"', '" + number +"')";
		Integer affected_rows = this.db.changeDBData(query);
		// Если добавление прошло успешно...
		if (affected_rows > 0)
		{			// Добавляем запись о человеке в общий список.
			HashMap<String,String> person_phones = person.getPhones();
			person_phones.put(this.db.getLastInsertId().toString(), number);
			person.setPhones(person_phones);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * edit chosen phone in the database
	 * @param person
	 * @param number
	 * @param number_id
	 * @return
	 */
	public boolean editPhone(Person person, String number, String number_id) {
		Integer id_filtered = Integer.parseInt(number_id);

		String query= "UPDATE `person` SET `number` = " + number + "' WHERE `owner` = "
				+ person.getId() + "' AND `id` =" + id_filtered;
		Integer affected_rows = this.db.changeDBData(query);

		if (affected_rows > 0) {
			HashMap<String,String> person_phones = person.getPhones();
			person_phones.put(number_id, number);
			person.setPhones(person_phones);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * delete phone from database
	 * @param person
	 * @param number_id
	 * @return
	 */
	public boolean deletePhone(Person person, String number_id) {
		if ((number_id != null)&&(!number_id.equals("null"))) {
			int filtered_id = Integer.parseInt(number_id);
			Integer affected_rows = this.db.changeDBData("DELETE FROM `phone` WHERE `id`=" + filtered_id);
			if (affected_rows > 0) {
				person.getPhones().remove(number_id);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// +++++++++++++++++++++++++++++++++++++++++
	// getters and setters
	public HashMap<String,Person> getContents()
	{
		return persons;
	}
	
	public Person getPerson(String id)
	{
		return this.persons.get(id);
	}
	// getters and setters
	// -----------------------------------------

}
