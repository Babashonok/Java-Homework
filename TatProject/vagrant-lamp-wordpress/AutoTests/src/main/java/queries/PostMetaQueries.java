package queries;



/**
 * describe variety of requests to the table wp_postmeta
 */
public class PostMetaQueries {
    private String refactoringTableName = "`wp_postmeta`";

    public String deletePostMeta() {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `meta_id`!='1'");
        return query.toString();
    }
}
