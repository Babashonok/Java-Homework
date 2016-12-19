package queries;

import user.User;

/**
 * describe variety of requests to the table wp_posts
 */
public class PostQueries {

    private String refactoringTableName = "`wp_posts`";

    public String deletePost(User user) {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `post_author`=").append(user.getID());
        return query.toString();
    }
}
