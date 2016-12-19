package queries;

import user.User;

/**
 * Created by alexeybabak on 19.12.16.
 */
public class CommentQueries {

    private String refactoringTableName = "`wp_comments`";

    public String deleteComment(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `user_id`=").append(user.getID());
        return query.toString();
    }
}
