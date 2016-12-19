package queries;

import user.User;

/**
 * describe variety of requests to the table wp_comments
 */
public class CommentQueries {

    private String refactoringTableName = "`wp_comments`";

    public String deleteComment(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `user_id`=").append(user.getID());
        return query.toString();
    }
}
