package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * Page Object for /Host_name/wp-admin/profile.php web page
 *
 */
public class ProfilePage extends AbstractPage {

    private By homePageLocator = By.xpath("//a[@href='http://localhost:8888/']");
    private By newPostPageLocator = By.xpath("//a[@href='http://localhost:8888/wp-admin/post-new.php']");
    private By dashboardPageLocator =By.xpath("//div[@class='wp-menu-name']");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProfilePage open() {
        driver.get("http://localhost:8888/wp-admin/profile.php");
        return this;
    }
    public HomePage goToHomePage() {
        this.driver.findElement(homePageLocator).click();
        return new HomePage(driver);
    }
    public NewPostPage goToNewPostCreationPage() {
        this.driver.findElement(newPostPageLocator).click();
        return new NewPostPage(driver);
    }
    public DashboardPage goToDashboardPage() {
        this.driver.findElement(dashboardPageLocator).click();
        return new DashboardPage(driver);
    }






}
