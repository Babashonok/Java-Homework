package pom;

import dataStorageForTests.CommonMethods;
import dataStorageForTests.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class HomePageTest {

    private WebDriver driver ;
    private HomePage homePage;
    private CommonMethods commonMethods = CommonMethods.getInstance();
    private Data data = Data.getInstance();


    @BeforeClass
    public void setUser() throws Exception {
        commonMethods.createUser(data.metaSubCap, data.metaSubLevel);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        homePage = new LoginPage(driver).open().loginAs(commonMethods.getUser().getUser_login(),
                commonMethods.getUser().getUser_pass()).goToHomePage();
    }

    @Test
    public void testInvalidSearch() throws Exception {
        homePage.search("tratata");
        assertNotNull(homePage.checkNotFoundTitle());

    }
    @Test
    public void testValidSearch() throws Exception {
        homePage.search("hello");
        assertNotNull(homePage.checkFoundPostTitle());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

    @AfterClass
    public void deleteUser() throws Exception {
        commonMethods.deleteUser();
    }

}