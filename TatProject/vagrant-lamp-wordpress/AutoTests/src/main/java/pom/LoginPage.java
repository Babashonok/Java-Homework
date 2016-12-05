package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for /Host_name/wp-login.php web page
 *
 * Created by alexeybabak on 4.12.16.
 */
public class LoginPage extends AbstractPage {

    private By usernameLocator = By.id("user_login");
    private By passwordLocator = By.id("user_pass");
    private By loginButtonLocator = By.id("wp-submit");



    public LoginPage(WebDriver driver) {
        super(driver);

    }
    @Override
    public LoginPage open() {
        this.driver.get("http://localhost:8888/wp-login.php");
        return this;
    }

    public LoginPage typeUsername(String username) {
        this.driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        this.driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public ProfilePage submitLogin() {
        this.driver.findElement(loginButtonLocator).submit();
        return new ProfilePage(this.driver);
    }

    public LoginPage submitLoginExpectingFailure() throws InterruptedException {
        this.driver.findElement(loginButtonLocator).submit();
        return new LoginPage(this.driver);
    }
    public boolean isFailed(String failMessage) {
        return this.driver.getPageSource().contains(failMessage);
    }

    public ProfilePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        submitLogin();
        return new ProfilePage(this.driver);
    }
}
