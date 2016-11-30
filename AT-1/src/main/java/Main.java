import commands.*;
import dataHandlers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import reports.ListOfReportsHandler;
import reports.LogFileBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.InputMismatchException;

/**
 * MicroFrameWork that perform list of commands in the web technology area
 * Using Selenium WebDriver ToolKit
 * @author Alexey Babak
 * @since 16.11.2016
 */
public class Main {
    /**
     * create list of file handlers with common parent FileHandler
     * @return list of file handlers
     */
    public static ListOfFileHandlers createListOfFileHandlers() {
        return new ListOfFileHandlers().add(new TXTHandler())
                                       .add(new XMLHandler())
                                       .add(new JSONHandler());
    }
    /**
     * create list of commands with common parent Command
     * @return list of commands
     */
    public static ListOfCommands createListOfCommands() {
        return new ListOfCommands().add(new OpenCommand())
                                   .add(new CheckLinkPresentByHrefCommand())
                                   .add(new CheckLinkPresentByNameCommand())
                                   .add(new CheckPageContainsCommand())
                                   .add(new CheckPageTitleCommand());
    }

    /**
     * create list of reports using command line to read commands
     * @param args arguments from the command line
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @return list of reports
     */
    public static ListOfReportsHandler createListFromCommandLine(String [] args, ListOfCommands listOfCommands, WebDriver driver) {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        commandLineHandler.performCommandCall(args, listOfCommands, driver);
        return commandLineHandler.sendReport();
    }

    /**
     * create list of reports using files to read commands
     * @param file File that contains all commands
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @return list of reports
     * @throws Exception if file wasn't created or cannot be open
     */
    public static ListOfReportsHandler createListFromFile(File file, ListOfCommands listOfCommands, WebDriver driver) throws Exception {
        ListOfFileHandlers listOfFileHandlers = createListOfFileHandlers();
        listOfFileHandlers.performCommandCall(file, listOfCommands, driver);
        return listOfFileHandlers.sendReport();
    }


    public static void main(String [] args) {

        WebDriver driver = new HtmlUnitDriver();
        File file = new File("test.xml");
        ListOfReportsHandler listOfReportsHandler ;
        ListOfCommands listOfCommands = createListOfCommands();
        try {
        if (args.length >= 1) {
            listOfReportsHandler = createListFromCommandLine(args, listOfCommands, driver);
        } else {
            listOfReportsHandler = createListFromFile(file, listOfCommands, driver);
        }
            File logFile = new File("logFile.txt");
            FileWriter input = new FileWriter(logFile);
            LogFileBuilder logFileBuilder = new LogFileBuilder(input, listOfReportsHandler);
            input.close();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("file wasn't created or cannot be open");
            System.exit(1);
        }
    }
 }
