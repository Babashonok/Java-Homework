package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Class that emulate checking link by name in the web page
 */
public class CheckLinkPresentByNameCommand extends Command {


    /**
     * take string representation of a request with arguments
     * and emulate it using Selenium WebDriver
     *
     * @param inputCommand list with command name and arguments
     * @param driver Selenium WebDriver chosen driver
     */
    @Override
    public void performCommand(ArrayList<String> inputCommand, WebDriver driver) {
        this.isPerformed = true;
        long start = System.currentTimeMillis();
        try{
            driver.findElement(By.xpath("//a[text()='" + inputCommand.get(1).replaceAll("\"", "") + "']"));
        }catch(NoSuchElementException e){
            this.isPerformed = false;
        }
        long end = System.currentTimeMillis();
        this.inputCommand = inputCommand;
        setTimeSpend(start, end);
    }

    /**
     * @return name of command
     */
    @Override
    public String getName() {
        return "checkLinkPresentByName";
    }
}
