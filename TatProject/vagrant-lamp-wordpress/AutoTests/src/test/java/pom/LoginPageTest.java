package pom;

import dbworker.DBWorker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import queries.UserMetaQueries;
import queries.UserQueries;
import user.User;
import user.UserMeta;


/**
 * Created by alexeybabak on 4.12.16.
 */
public class LoginPageTest {

    WebDriver driver ;
    LoginPage loginPage;
    DBWorker db = DBWorker.getInstance();
    User user = new User("Alexey","test", "Alexey",
            "222@mail.ru", "http://test.com", "", 0, "Alexey");
    UserMeta meta1 = new UserMeta("wp_capabilities","a:1:{s:10:" + '"' + "subscriber" + '"' +";b:1;}");
    UserMeta meta2 = new UserMeta("wp_user_level", "10");
    UserQueries userQueries = new UserQueries();
    UserMetaQueries metaQueries = new UserMetaQueries();

    @BeforeClass
    public void setUser() throws Exception {
        driver = new HtmlUnitDriver();
        db.changeDBData(userQueries.addUser(user));
        user.setID(db);
        db.changeDBData(metaQueries.addUserMeta(user, meta1));
        db.changeDBData(metaQueries.addUserMeta(user, meta2));
    }


    @BeforeMethod
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver).open();
    }
    @Test
    public void testValidAuthorization() throws Exception {
        ProfilePage profilePage = loginPage.loginAs(user.getUser_login(),user.getUser_pass());
        assertTrue(profilePage.getTitle().contains("Profile"));    }
    @Test
    public void testValidAdminAuthorization() throws Exception {
        ProfilePage profilePage = loginPage.loginAs("user","user");
        assertEquals(profilePage.getTitle(),"Dashboard ‹ Autotests — WordPress");
    }
    @Test
    public void lostPassword() {

        WebElement nullPass = loginPage.findLinkText("Lost your password?");
        nullPass.click();
        assertTrue( loginPage.getTitle().contains("Autotests ‹ Lost Password"));
    }
    @Test
    public void negativeAuthorization() throws Exception{
        LoginPage loginPage2 = loginPage.submitLoginExpectingFailure();
        assertNotNull(loginPage2.findByXPath("//div[@id='login_error']"));
    }

    @AfterClass
    public void deleteUser() throws Exception {
        db.changeDBData(userQueries.deleteUser(user));
        db.changeDBData(metaQueries.deleteUserMeta(user));

    }

}