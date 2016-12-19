package pom;

import dataStorageForTests.CommonMethods;
import dataStorageForTests.Data;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.WebDriver;


/**
 * Created by alexeybabak on 4.12.16.
 */
public class LoginPageTest {

    private WebDriver driver ;
    private LoginPage loginPage;
    private CommonMethods commonMethods = CommonMethods.getInstance();
    private Data data = Data.getInstance();

    @BeforeClass
    public void setUser() throws Exception {
       commonMethods.createUser(data.metaSubCap, data.metaSubLevel);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver).open();
    }

    @Test
    public void testValidAuthorization() throws Exception {
        ProfilePage profilePage = loginPage.loginAs(commonMethods.getUser().getUser_login(), commonMethods.getUser().getUser_pass());
        assertTrue(profilePage.getTitle().contains("Profile"));
    }

    @Test
    public void testValidAdminAuthorization() throws Exception {
        ProfilePage profilePage = loginPage.loginAs("user","user");
        assertEquals(profilePage.getTitle(),"Dashboard ‹ Autotests — WordPress");
    }

    @Test
    public void lostPassword() {
        loginPage.findLinkText("Lost your password?").click();
        assertTrue( loginPage.getTitle().contains("Autotests ‹ Lost Password"));
    }

    @Test
    public void negativeAuthorization() throws Exception{
        loginPage.typeUsername(commonMethods.getUser().getUser_login()).submitLoginExpectingFailure();
        assertNotNull(loginPage.findByXPath("//div[@id='login_error']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @AfterClass
    public void deleteUser() throws Exception {
        commonMethods.deleteUser();

    }

}