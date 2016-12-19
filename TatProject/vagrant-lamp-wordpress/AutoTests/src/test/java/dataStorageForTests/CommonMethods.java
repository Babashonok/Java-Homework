package dataStorageForTests;

import dbworker.DBWorker;
import queries.*;
import user.User;
import user.UserMeta;

/**
 * Created by alexeybabak on 18.12.16.
 */
public class CommonMethods {

    Data data = Data.getInstance();
    DBWorker db = DBWorker.getInstance();

    UserQueries userQueries = new UserQueries();
    UserMetaQueries metaQueries = new UserMetaQueries();
    PostQueries postQueries = new PostQueries();
    PostMetaQueries postMetaQueries = new PostMetaQueries();
    TermRelationshipsQueries termRelationshipsQueries = new TermRelationshipsQueries();
    CommentQueries commentQueries = new CommentQueries();
    CommentMetaQueries commentMetaQueries = new CommentMetaQueries();

    private static CommonMethods instance;

    private CommonMethods () {}

    public static synchronized CommonMethods getInstance() {
        if (instance == null) {
            instance = new CommonMethods();
        }
        return instance;
    }

    public void createUser(UserMeta metaRole, UserMeta metaLevel) throws Exception{
        db.changeDBData(userQueries.addUser(data.user));
        data.user.setID(db);
        db.changeDBData(metaQueries.addUserMeta(data.user, metaRole));
        db.changeDBData(metaQueries.addUserMeta(data.user, metaLevel));
    }
    public void deleteUser() {
        db.changeDBData(userQueries.deleteUser(data.user));
        db.changeDBData(metaQueries.deleteUserMeta(data.user));
    }
    public void deletePost() {
        db.changeDBData(postQueries.deletePost(data.user));
        db.changeDBData(postMetaQueries.deletePostMeta());
        db.changeDBData(termRelationshipsQueries.deleteRelationship());
    }
    public void deleteComment() {
        db.changeDBData(commentQueries.deleteComment(data.user));
        db.changeDBData(commentMetaQueries.deleteCommentMeta());
    }

    public User getUser() {
        return data.user;
    }
}
