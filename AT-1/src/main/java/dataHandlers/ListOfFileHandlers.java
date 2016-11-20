package dataHandlers;

import commands.ListOfCommands;
import org.openqa.selenium.WebDriver;
import reports.ListOfReportsHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Create list of objects that has common parent class FileHandler
 * every object works with own file extension
 * Output information about every Object of the list
 */
public class ListOfFileHandlers implements Reportable{

    private ArrayList<FileHandler> fileHandlerList = new ArrayList<>();
    private String usedFileReader;

    /**
     * add  object that inherits class FileHandler
     * @param fileHandler any inherited object
     * @return link to added element
     */
    public ListOfFileHandlers add(FileHandler fileHandler) {
        fileHandlerList.add(fileHandler);
        return this;
    }

    /**
     * call method performCommands from inheritor
     * which has equal extension with file
     * @param file File that contains all commands
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @throws Exception if file wasn't created or cannot be open
     */
    public void performCommandCall(File file, ListOfCommands listOfCommands, WebDriver driver) throws Exception {
        boolean rightInput = false;
        for (FileHandler fileHandler : fileHandlerList) {
            if (file.getName().contains(fileHandler.getExtension())) {
                this.usedFileReader = file.getName();
                fileHandler.performCommands(file, listOfCommands, driver);
                rightInput = true;
            }
        }
        if (!rightInput) {
            throw new InputMismatchException("try to use file with valid extension next time");
        }
    }

    /**
     * @return list of reports , null if wrong extension caught here
     */
    @Override
    public ListOfReportsHandler sendReport() {
        for (FileHandler fileHandler : fileHandlerList) {
            if (usedFileReader.contains(fileHandler.getExtension())) {
                return fileHandler.sendReport();
            }
        }
        return null;
    }
}
