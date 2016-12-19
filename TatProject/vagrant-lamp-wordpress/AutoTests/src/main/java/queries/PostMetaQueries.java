package queries;



/**
 * Created by alexeybabak on 18.12.16.
 */
public class PostMetaQueries {
    private String refactoringTableName = "`wp_postmeta`";

    public String deletePostMeta() {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `meta_id`!='1'");
        return query.toString();
    }
}
