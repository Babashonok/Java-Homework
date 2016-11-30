package dataHandlers;

import commands.ListOfCommands;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read information from .txt files and handle it
 * also can send report about every command
 */
public class TXTHandler extends FileHandler implements Reportable{

    /**
     * @return extension, which this class can handle
     */
    @Override
    public String getExtension() {
        return ".txt";
    }

    /**
     * perform all commands that contains in read file
     * @param file File that contains all commands
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @throws FileNotFoundException if file wasn't created or cannot be open
     */
    @Override
    public void performCommands(File file, ListOfCommands listOfCommands, WebDriver driver) throws FileNotFoundException  {
          Scanner scanner = new Scanner(file);
          while (scanner.hasNextLine()) {
              inputCommand = read(scanner);
              listOfCommands.performCommand(inputCommand, driver);
              listOfReportsHandler.add(listOfCommands.sendReport(inputCommand));
          }
    }

    /**
     * read from .txt file and return completed array list
     * with name and arguments
     * @param scanner tool to read from .txt file
     * @return ame of the command and it arguments as ArrayList<String>
     */
    private ArrayList<String> read(Scanner scanner) {
        ArrayList <String> tempList = new ArrayList<>();
            tempList.add(scanner.next());
        if (tempList.get(0).equals("open")) {
            tempList.add(scanner.next());
            tempList.add(scanner.next());
        } else {
            tempList.add(scanner.nextLine().substring(1));
        }
        return tempList;
    }


}
