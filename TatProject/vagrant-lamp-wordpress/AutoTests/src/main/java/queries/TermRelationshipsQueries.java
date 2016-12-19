package queries;



/**
 * describe variety of requests to the table wp_term_relationships
 */
public class TermRelationshipsQueries {

    private String refactoringTableName = "`wp_term_relationships`";

    public String deleteRelationship() {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        query.append(refactoringTableName).append(" WHERE `object_id`!='1'");
        return query.toString();
    }
}
