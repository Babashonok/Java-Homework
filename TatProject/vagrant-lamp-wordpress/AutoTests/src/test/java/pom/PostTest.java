package pom;

import dataStorageForTests.CommonMethods;
import dataStorageForTests.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;




/**
 * Created by alexeybabak on 5.12.16.
 */
public class PostTest {

    private WebDriver driver;
    private ProfilePage profilePage;
    private CommonMethods commonMethods = CommonMethods.getInstance();
    private Data data = Data.getInstance();

    @BeforeClass
    public void setUser() throws Exception {
        commonMethods.createUser(data.metaAuthorCap, data.metaAuthorLevel);
    }

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        profilePage = new LoginPage(driver).open().loginAs(commonMethods.getUser().getUser_login(),
                commonMethods.getUser().getUser_pass());
    }

    @Test
    public void positiveAddPostWithTitle()  {
        NewPostPage newPostPage = profilePage.goToNewPostCreationPage();
        newPostPage.inputTitle("Hell").publishPost();
        assertNotNull(newPostPage.checkValidPublish());

    }
    @Test
    public void testQuickDraftPosting() throws InterruptedException {
        DashboardPage dashboardPage = profilePage.goToDashboardPage()
                .inputQuickDraftTitle("hello").inputQuickDraftContent("hey");
        dashboardPage.publishQuickDraft();
        assertNotNull(dashboardPage.checkDraftLabel());
    }



    @AfterMethod
    public void tearDown() {
        driver.close();
        commonMethods.deletePost();
    }

    @AfterClass
    public void deleteUser() throws Exception {
        commonMethods.deleteUser();
    }


}
