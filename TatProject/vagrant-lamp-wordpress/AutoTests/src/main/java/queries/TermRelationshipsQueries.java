package queries;



/**
 * Created by alexeybabak on 19.12.16.
 */
public class TermRelationshipsQueries {

    private String refactoringTableName = "`wp_term_relationships`";

    public String deleteRelationship() {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `object_id`!='1'");
        return query.toString();
    }
}
