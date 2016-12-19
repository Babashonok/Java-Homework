package pom;

import dataStorageForTests.CommonMethods;
import dataStorageForTests.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CommentTest {

    private WebDriver driver;
    private HomePage homePage;
    private CommonMethods commonMethods = CommonMethods.getInstance();
    private Data data = Data.getInstance();

    @BeforeClass
    public void setUser() throws Exception {
        commonMethods.createUser(data.metaAuthorCap, data.metaAuthorLevel);
    }
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        homePage = new LoginPage(driver).open().loginAs(commonMethods.getUser().getUser_login(),
                commonMethods.getUser().getUser_pass()).goToHomePage();
    }
    @Test
    public void testValidCommentOnDefaultPost() {
        homePage.goToComments().inputComment("comment").publishComment();
        assertTrue(homePage.isCommentPublishedByCurrentUser(commonMethods.getUser()));
    }


    @AfterMethod
    public void tearDown() throws Exception {
        commonMethods.deleteComment();
        driver.close();
    }

    @AfterClass
    public void deleteUser() throws Exception {
        commonMethods.deleteUser();
    }

}
