package commands;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Class that emulate checking info containment in the HTML representation of the web page
 */
public class CheckPageContainsCommand extends Command {


    /**
     * take string representation of a request with arguments
     * and emulate it using Selenium WebDriver
     *
     * @param inputCommand list with command name and arguments
     * @param driver Selenium WebDriver chosen driver
     */
    @Override
    public void performCommand(ArrayList<String> inputCommand, WebDriver driver) {
        this.isPerformed = false;
        long start = System.currentTimeMillis();
        if (driver.getPageSource().contains(inputCommand.get(1).replaceAll("\"", ""))) {
            this.isPerformed = true;
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
        return "checkPageContains";
    }
}
