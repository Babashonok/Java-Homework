package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
	

	private Integer affected_rows = 0;
	private Integer last_insert_id = 0;

	private static DBWorker instance = null;

	/**
	 * get single instance of this class
	 * @return
	 */
	public static DBWorker getInstance() {
		if (instance == null) {
			instance = new DBWorker();
		}
		return instance;
	}

	/**
	 * disallow straight request to the object
	 */
	private DBWorker() {
	}

	/**
	 * perform resuest of the data select
	 * @param query
	 * @return
	 */
	public ResultSet getDBData(String query) {
		Statement statement;
		Connection connect;
		try	{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=only906090&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			return resultSet;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)	{
			e.printStackTrace();
		}
		
		System.out.println("null on getDBData()!");
		return null;

	}

	/**
	 * perform request of the database modification
	 * @param query
	 * @return
	 */
	public Integer changeDBData(String query)
	{
		Statement statement;
		Connection connect;
		try	{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=only906090&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
			statement = connect.createStatement();
			this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			// Получаем last_insert_id() для операции вставки.
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
            	this.last_insert_id = rs.getInt(1);
            }
			return this.affected_rows;
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("null on changeDBData()!");
		return null;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++
	// getters and setters
	public Integer getAffectedRowsCount()
	{
		return this.affected_rows;
	}
	
	public Integer getLastInsertId()
	{
		return this.last_insert_id;
	}
	// getters and setters.
	// -------------------------------------------------
}
