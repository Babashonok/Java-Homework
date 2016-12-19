package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * abstract parent class for page objects classes
 * describe simple driver commands and close it from test logic
 *
 */
public abstract class AbstractPage {

    protected final WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract AbstractPage open();


    public WebElement findByXPath(String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement;
    }
    public WebElement findLinkText(String linkText) {
        WebElement webElement = driver.findElement(By.linkText(linkText));
        return webElement;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
