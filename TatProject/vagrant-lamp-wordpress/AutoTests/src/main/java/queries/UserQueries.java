package queries;

import org.apache.commons.codec.digest.DigestUtils;
import user.User;

/**
 * describe variety of requests to the table wp_users
 *
 * Created by alexeybabak on 3.12.16.
 */
public class UserQueries  {

    private String refactoringTableName = "`wp_users`";

    public String addUser(User user) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(refactoringTableName).append("(`user_login`, `user_pass`, `user_nicename`,")
                .append(" `user_email`, `user_url`, `user_registered`, `user_status`, `display_name`")
                .append(") VALUES ('").append(user.getUser_login()).append("', '").append(DigestUtils.md5Hex(user.getUser_pass()))
                .append("', '").append(user.getUser_nicename()).append("', '").append(user.getUser_email()).append("', '")
                .append(user.getUser_url()).append("', '").append(user.getFormat_registered()).append("', '")
                .append(user.getUser_status()).append("', '").append(user.getDisplay_name()).append("')");
        return query.toString();
    }
    public String deleteUser(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `ID`=").append(user.getID());
        return query.toString();
    }
    public String getUserID(User user) {
        StringBuilder query = new StringBuilder("SELECT `ID` FROM ").append(refactoringTableName)
                .append( "WHERE `user_login` ='").append(user.getUser_login()).append("' AND `user_pass` ='")
                .append(DigestUtils.md5Hex(user.getUser_pass())).append("'");
        return query.toString();
    }
