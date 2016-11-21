package commands;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Class that emulate checking link by href in the web page
 */
public class CheckLinkPresentByHrefCommand extends Command {

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
            webDriver.findElement(By.xpath("//a[@href='" + inputCommand.get(1) + "']"));
        }catch(NoSuchElementException e){
            this.isPerformed = false;
        }
        long end = System.currentTimeMillis();
        this.inputCommand = inputCommand;
        setTimeSpend(start, end);
    }

    /**
     * @return name of the command
     */
    @Override
    public String getName() {
        return "checkLinkPresentByHref";
    }
}
