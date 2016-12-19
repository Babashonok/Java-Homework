package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import user.User;

/**
 *Page Object for /Host_name web page
 */
public class HomePage extends AbstractPage {

    private By searchLocator = By.xpath("//section[@id='search-2']/form/label");
    private By searchButton = By.xpath("//section[@id='search-2']/form/button");
    private By notFoundTitle = By.xpath("//section[@class='no-results not-found']");
    private By foundPost = By.xpath("//article[@id='post-1']");
    private By defaultPostCommentsLocator = By.xpath("//a[@href='http://localhost:8888/?p=1#comments']");
    private By commentTextArea = By.xpath("//textarea[@id='comment']");
    private By submitComment = By.xpath("//input[@id='submit']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public AbstractPage open() {
        this.driver.get("http://localhost:8888");
        return this;
    }
    public AbstractPage search(String input) {
        this.driver.findElement(searchLocator).click();
        this.driver.findElement(searchLocator).sendKeys(input);
        this.driver.findElement(searchButton).click();
        return this;
    }
    public WebElement checkNotFoundTitle() {
        return this.driver.findElement(notFoundTitle);
    }
    public WebElement checkFoundPostTitle() {
        return this.driver.findElement(foundPost);
    }
    public HomePage goToComments() {
        this.driver.findElement(defaultPostCommentsLocator).click();
        return this;
    }
    public HomePage inputComment(String comment) {
        this.driver.findElement(commentTextArea).sendKeys(comment);
        return this;
    }
    public HomePage publishComment() {
        this.driver.findElement(submitComment).click();
        return this;
    }
    public boolean isCommentPublishedByCurrentUser(User user) {
        return this.driver.getPageSource().contains(user.getUser_nicename());
    }
}
