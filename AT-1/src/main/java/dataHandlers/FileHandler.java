package dataHandlers;

import commands.ListOfCommands;
import org.openqa.selenium.WebDriver;
import reports.ListOfReportsHandler;

import java.io.File;
import java.util.ArrayList;


/**
 * Read information from Files and handle it
 * also can send report about every command
 * Parent abstract class to all possible file type handlers
 */
public abstract class FileHandler implements Reportable {

    ArrayList<String> inputCommand = new ArrayList<>();
    ListOfReportsHandler listOfReportsHandler = new ListOfReportsHandler();

    /**
     * @return extension, which this class can handle
     */
    public abstract String getExtension();

    /**
     * perform all commands that contains in read file
     * @param file File that contains all commands
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @throws Exception if file wasn't created or cannot be open
     */
    public abstract void performCommands(File file, ListOfCommands listOfCommands, WebDriver driver) throws Exception;
    /**
     * @return list of reports
     */
    @Override
    public ListOfReportsHandler sendReport() {
        return this.listOfReportsHandler;
    }
}
