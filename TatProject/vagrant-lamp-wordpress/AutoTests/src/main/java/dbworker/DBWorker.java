package dbworker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class that provide interaction between database and java application
 */
public class DBWorker {


    private Integer affected_rows = 0;
    private Integer last_insert_id = 0;

    private String url = "jdbc:mysql://localhost:8889/wordpress";
    private String user = "root";
    private String password = "root";

    private static DBWorker instance = null;

    /**
     * get single instance of this class
     *
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
     *
     */
    private DBWorker() {
    }

    /**
     * perform request of the data select
     *
     * @param query any request to work with database data
     * @return
     */
    public ResultSet getDBData(String query) {
        Statement statement;
        Connection connect;
        try	{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, user, password);
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
     *
     * @param query any request to work with database data
     * @return
     */
    public Integer changeDBData(String query)
    {
        Statement statement;
        Connection connect;
        try	{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, user, password);
            statement = connect.createStatement();
            this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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


    public Integer getAffectedRowsCount()
    {
        return this.affected_rows;
    }

    public Integer getLastInsertId()
    {
        return this.last_insert_id;
    }

}
