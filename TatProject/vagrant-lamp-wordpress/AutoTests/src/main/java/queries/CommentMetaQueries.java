package queries;

/**
 * Created by alexeybabak on 19.12.16.
 */
public class CommentMetaQueries {
    private String refactoringTableName = "`wp_commentmeta`";

    public String deleteCommentMeta() {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `meta_id`!='-1'");
        return query.toString();
    }
}
