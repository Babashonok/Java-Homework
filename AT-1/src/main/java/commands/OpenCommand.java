package commands;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Class that emulate opening of the web page
 */
public class OpenCommand extends Command {
    /**
     * take string representation of a request with arguments
     * and emulate it using Selenium WebDriver
     * check time spend by the program to open current page
     *
     * @param inputCommand list with command name and arguments
     * @param driver Selenium WebDriver chosen driver
     */
    @Override
    public void performCommand(ArrayList<String> inputCommand, WebDriver driver) {
        long start = System.currentTimeMillis();
        driver.get(inputCommand.get(1).replaceAll("\"", ""));
        double timeout =Double.parseDouble(inputCommand.get(2).replace('"',' '));
        long end = System.currentTimeMillis();
        this.inputCommand = inputCommand;
        setTimeSpend(start, end);
        this.isPerformed = Double.valueOf(timeSpend).compareTo(timeout) != 1;
    }

    /**
     * @return name of command
     */
    @Override
    public String getName() {
        return "open";
    }
}
