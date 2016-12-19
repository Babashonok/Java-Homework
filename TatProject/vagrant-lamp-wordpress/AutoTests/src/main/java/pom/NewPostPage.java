package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Page Object for /Host_name/wp-admin/post-new.php web page
 */
public class NewPostPage extends AbstractPage {
    private By postTitleLocator = By.xpath("//input[@id='title']");
    private By successPostLabel = By.xpath("//div[@class='updated notice notice-success is-dismissible']");
    private By publishButton = By.xpath("//input[@id='publish']");
    public NewPostPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public AbstractPage open() {
        this.driver.get("http://localhost:8888/wp-admin/post-new.php");
        return this;
    }
    public NewPostPage inputTitle(String title) {
        this.driver.findElement(postTitleLocator).sendKeys(title);
        return this;
    }

    public WebElement checkValidPublish() {
        return this.driver.findElement(successPostLabel);
    }


    public NewPostPage publishPost() {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.findElement(publishButton).click();
        return this;
    }
}
