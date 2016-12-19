package user;

import dbworker.DBWorker;
import queries.UserMetaQueries;
import queries.UserQueries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Class that describes wp_users table rows
 * used in user registration by database requests
 *
 * Created by alexeybabak on 3.12.16.
 */
public class User {

    private int ID;
    private String user_login;
    private String user_pass;
    private String user_nicename;
    private String user_email;
    private String user_url;
    private String user_activation_key;
    private int user_status;
    private String display_name;

    public User (String user_login, String user_pass, String user_nicename,
                 String user_email, String user_url, String user_activation_key,
                 int user_status, String display_name) {
        this.user_login = user_login;
        this.user_pass = user_pass;
        this.user_nicename =user_nicename;
        this.user_email = user_email;
        this.user_url = user_url;
        this.user_activation_key = user_activation_key;
        this.user_status = user_status;
        this.display_name = display_name;
    }

    public String getUser_login() {
        return user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public String getUser_nicename() {
        return user_nicename;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_url() {
        return user_url;
    }

    public String getFormat_registered() {
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getUser_activation_key() {
        return user_activation_key;
    }

    public String getUser_status() {
        return String.valueOf(user_status);
    }

    public String getDisplay_name() {
        return display_name;
    }

    public int getID() {
        return ID;
    }

    public void setID(DBWorker db) throws SQLException {
        UserQueries userQueries = new UserQueries();
        ResultSet resultSet = db.getDBData(userQueries.getUserID(this));
        resultSet.next();
        this.ID = resultSet.getInt("ID");
    }
}
