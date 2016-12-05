package user;

/**
 * Class that describes wp_usermeta table rows
 * used in user registration by database
 *
 * Created by alexeybabak on 3.12.16.
 */
public class UserMeta {

    private String meta_key;
    private String meta_value;

    public UserMeta(String meta_key, String meta_value) {
        this.meta_key = meta_key;
        this.meta_value = meta_value;
    }


    public String getMeta_key() {
        return meta_key;
    }

    public String getMeta_value() {
        return meta_value;
    }
}
