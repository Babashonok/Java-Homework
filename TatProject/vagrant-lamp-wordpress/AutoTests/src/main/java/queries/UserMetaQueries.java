package queries;

import user.User;
import user.UserMeta;

/**
 * describe variety of requests to the table wp_usermeta
 *
 */
public class UserMetaQueries  {

    private String refactoringTableName = "`wp_usermeta`";

    public String addUserMeta(User user, UserMeta userMeta) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(refactoringTableName).append("(`user_id`, `meta_key`, `meta_value`")
                .append(") VALUES ('").append(user.getID()).append("', '").append(userMeta.getMeta_key())
                .append("', '").append(userMeta.getMeta_value()).append("')");
        return query.toString();
    }
    public String deleteUserMeta(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `user_id`=").append(user.getID());
        return query.toString();
    }
}
