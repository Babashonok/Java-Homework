package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.DBWorker;

/**
 * template for Person obiects
 */
public class Person {
	

	private String id = "";
	private String name = "";
	private String surname = "";
	private String middlename = "";
	private HashMap<String,String> phones = new HashMap<String,String>();

	/**
	 * Constructor that initialize person fields and fill
	 * phones hashMap from the Database
	 * @param id input id
	 * @param name input name
	 * @param surname input surname
	 * @param middlename input middlename
	 */
	public Person(String id, String name, String surname, String middlename) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.middlename = middlename;
		// Извлечение телефонов человека из БД.
		ResultSet db_data = DBWorker.getInstance().getDBData("SELECT * FROM `phone` WHERE `owner`=" + id);
		
		try	{
			// Если у человека нет телефонов, ResultSet будет == null.
			if (db_data != null) {
				while (db_data.next()) {
					this.phones.put(db_data.getString("id"), db_data.getString("number"));
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *default constructor of the non-initialized person
	 */
	public Person()	{
		this.id = "0";
		this.name = "";
		this.surname = "";
		this.middlename = "";
	}

	/**
	 * constructor for adding to the database
	 */
	public Person(String name, String surname, String middlename) {
		this.id = "0";
		this.name = name;
		this.surname = surname;
		this.middlename = middlename;
	}

	/**
	 * check is value of the string fields is valid
	 * @param fml_name_part any of the string fileds of the person
	 * @param empty_allowed allow empty middlename
	 * @return
	 */
	public boolean validateFMLNamePart(String fml_name_part, boolean empty_allowed)	{
		if (empty_allowed) {
			Matcher matcher = Pattern.compile("[А-Яа-я]{0,150}").matcher(fml_name_part);
			return matcher.matches();
		} else {
			Matcher matcher = Pattern.compile("[А-Яа-я]{1,150}").matcher(fml_name_part);
			return matcher.matches();
		}

	}

	// ++++++++++++++++++++++++++++++++++++++
	// Getters and Setters
	public String getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}

	public String getSurname()
	{
		return this.surname;
	}
	
	public String getMiddlename()  {
		if ((this.middlename != null)&&(!this.middlename.equals("null"))) {
			return this.middlename;
		} else {
			return "";
		}
	}

	public HashMap<String,String> getPhones()
	{
		return this.phones;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setPhones(HashMap<String,String> phones)
	{
		this.phones = phones;
	}
	// Getters and Setters
	// --------------------------------------
	
}
