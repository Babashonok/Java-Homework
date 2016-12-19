package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Page Object for /Host_name/wp-admin/index.php web page
 */
public class DashboardPage extends AbstractPage {

    private By quickDraftTitle = By.xpath("//input[@id='title']");
    private By quickDraftContent = By.xpath("//textarea[@id='content']");
    private By publishButton = By.xpath("//input[@id='save-post']");
    private By draftLabel = By.xpath("//div[@class='drafts']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage open() {
        this.driver.get("http://localhost:8888/wp-admin/index.php");
        return this;
    }
    public DashboardPage inputQuickDraftTitle(String title) {
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        this.driver.findElement(quickDraftTitle).sendKeys(title);
        return this;
    }
    public DashboardPage inputQuickDraftContent(String content) {
        this.driver.findElement(quickDraftContent).sendKeys(content);
        return this;
    }
    public DashboardPage publishQuickDraft() {
        this.driver.findElement(publishButton).click();
        return this;
    }
    public WebElement checkDraftLabel() {
        return this.driver.findElement(draftLabel);
    }
}
