package dataHandlers;

import commands.ListOfCommands;
import org.openqa.selenium.WebDriver;
import reports.ListOfReportsHandler;

import java.util.ArrayList;


/**
 * Read information from command line and handle it
 * also can send report about every command
 */
public class CommandLineHandler implements Reportable {

    private ListOfReportsHandler listOfReportsHandler = new ListOfReportsHandler();

    /**
     * perform all commands that contains in command line array
     * @param args arguments from the command line
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     */
    public void performCommandCall(String [] args, ListOfCommands listOfCommands, WebDriver driver){
        int arrayCounter = 0;
        while (arrayCounter < args.length) {
            ArrayList<String> inputCommand = read(args, arrayCounter);
            arrayCounter += inputCommand.size();
            listOfCommands.performCommand(inputCommand, driver);
            listOfReportsHandler.add(listOfCommands.sendReport(inputCommand));
        }
    }

    /**
     * read from command line and return completed array list
     * with name and arguments
     * @param args arguments from the command line
     * @param arrayCounter number of element from args array
     * @return name of the command and it arguments as ArrayList<String>
     */
    private ArrayList<String> read(String[] args, int arrayCounter) {
        ArrayList <String> tempList = new ArrayList<>();
        tempList.add(args[arrayCounter]);
        if (tempList.get(0).equals("open")) {
            tempList.add(args[arrayCounter + 1]);
            tempList.add(args[arrayCounter + 2]);
        } else {
            tempList.add(args[arrayCounter + 1]);
        }
        return tempList;
    }

    /**
     * @return list of reports
     */
    @Override
    public ListOfReportsHandler sendReport() {
        return this.listOfReportsHandler;
    }
}
