package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Page Object for /Host_name/wp-admin/profile.php web page
 *
 * Created by alexeybabak on 4.12.16.
 */
public class ProfilePage extends AbstractPage {

    private By submitButtonLocator = By.id("submit");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProfilePage open() {
        driver.get("http://localhost:8888/wp-admin/profile.php");
        return this;
    }

    public ProfilePage submitLogin() throws InterruptedException {
        driver.findElement(submitButtonLocator).submit();
        return new ProfilePage(driver);
    }



}
