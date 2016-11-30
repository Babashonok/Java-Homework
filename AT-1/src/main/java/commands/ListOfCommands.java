package commands;

import org.openqa.selenium.WebDriver;
import reports.TestReport;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Create list of objects that has common parent class Command
 * Output information about every Object of the list
 */
public class ListOfCommands {

    private ArrayList<Command> listOfCommands = new ArrayList<>();

    /**
     * add  object that inherits class Command
     * @param command any inherited object
     * @return link to added element
     */
    public ListOfCommands add(Command command) {
        listOfCommands.add(command);
        return this;
    }

    /**
     * call this method from inheritor
     * which has equal name with input String command name
     *
     * @param inputString list with command name and arguments
     * @param driver Selenium WebDriver chosen driver
     */
    public void performCommand(ArrayList<String> inputString, WebDriver driver) {
        boolean rightInput = false;
        for (Command command : listOfCommands) {
            if (command.getName().equals(inputString.get(0))) {
                command.performCommand(inputString, driver);
                rightInput = true;
            }
        }
        if(!rightInput) {
            throw new InputMismatchException("try to input valid commands next time");
        }
    }

    /**
     * call this method from inheritor
     * which has equal name with input String command name
     * @param inputString list with command name and arguments
     * @return report about performed command
     */
    public TestReport sendReport(ArrayList <String> inputString) {
        for (Command command : listOfCommands) {
            if (command.getName().equals(inputString.get(0))) {
                return command.createReport();
            }
        }
        return null;
    }
}
