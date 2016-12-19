package dataStorageForTests;

import dbworker.DBWorker;
import queries.UserMetaQueries;
import queries.UserQueries;
import user.User;
import user.UserMeta;

/**
 * Storage for Objects that will be used during test run
 */
public class Data {


    User user = new User("Alexey", "test", "Alexey",
            "222@mail.ru", "http://test.com", "", 0, "Alexey");
    public UserMeta metaSubCap = new UserMeta("wp_capabilities", "a:1:{s:10:" + '"' + "subscriber" + '"' + ";b:1;}");
    public UserMeta metaSubLevel = new UserMeta("wp_user_level", "10");
    public UserMeta metaAuthorCap = new UserMeta("wp_capabilities", "a:1:{s:6:" + '"' + "author" + '"' + ";b:1;}");
    public UserMeta metaAuthorLevel = new UserMeta("wp_user_level", "2");

    private static Data instance;

    private Data () {}

    public static synchronized Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

}



