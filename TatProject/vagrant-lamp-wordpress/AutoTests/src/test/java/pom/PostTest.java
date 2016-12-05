package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

/**
 * Created by alexeybabak on 5.12.16.
 */
public class PostTest {

    WebDriver driver ;

    @BeforeClass
    public void beforeClass() {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8888/wp-admin/profile.php");
    }
    @Test
    public void positiveAddPostFromSubmenuWithTitle() {
        driver.findElement(By.xpath("//a[@href='http://localhost:8888/wp-admin/post-new.php']")).click();

        driver.findElement(By.xpath("//input[@id='title']")).sendKeys("title");
        driver.findElement(By.xpath("//button[@id='content-html']")).click();
        driver.findElement(By.xpath("//textarea[@class='wp-editor-area']")).sendKeys("words");
        try {
            driver.wait(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//input[@id='publish']")).click();
        WebElement checkCreation = driver.findElement(By.xpath("//a[text()='View post']"));
        assertNotNull(checkCreation);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
