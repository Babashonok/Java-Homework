package pom;

import dataStorageForTests.CommonMethods;
import dataStorageForTests.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class ProfilePageTest {

    private WebDriver driver ;
    private ProfilePage profilePage;
    private CommonMethods commonMethods = CommonMethods.getInstance();
    private Data data = Data.getInstance();

    @BeforeClass
    public void setUser() throws Exception {
        commonMethods.createUser(data.metaSubCap, data.metaSubLevel);
    }


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        profilePage = new LoginPage(driver).open().loginAs(commonMethods.getUser().getUser_login(),
                                                           commonMethods.getUser().getUser_pass());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testGoToHomePage() throws Exception {
        HomePage homePage = profilePage.goToHomePage();
        assertEquals(homePage.getTitle(), "Autotests – Just another WordPress site");

    }

    @AfterClass
    public void deleteUser() throws Exception {
        commonMethods.deleteUser();
    }

}