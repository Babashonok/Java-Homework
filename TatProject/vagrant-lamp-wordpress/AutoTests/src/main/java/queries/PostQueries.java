package queries;

import user.User;

/**
 * Created by alexeybabak on 18.12.16.
 */
public class PostQueries {

    private String refactoringTableName = "`wp_posts`";

    public String deletePost(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `post_author`=").append(user.getID());
        return query.toString();
    }
}
