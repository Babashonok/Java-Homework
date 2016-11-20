package dataHandlers;

import commands.ListOfCommands;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Read information from .xml files and handle it
 * also can send report about every command
 */
public class XMLHandler extends FileHandler {

    /**
     * @return extension, which this class can handle
     */
    @Override
    public String getExtension() {
        return ".xml";
    }

    /**
     * perform all commands that contains in read file
     * @param file File that contains all commands
     * @param listOfCommands list of available commands
     * @param driver Selenium WebDriver chosen driver
     * @throws Exception if file wasn't created or cannot be open
     */
    @Override
    public void performCommands(File file, ListOfCommands listOfCommands, WebDriver driver) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodes = document.getElementsByTagName("command");
        for (int i = 0 ; i <nodes.getLength() ; i++) {
            NamedNodeMap attrs = nodes.item(i).getAttributes();
            inputCommand = read(attrs);
            listOfCommands.performCommand(inputCommand, driver);
            listOfReportsHandler.add(listOfCommands.sendReport(inputCommand));
        }
    }
    /**
     * read from .txt file and return completed array list
     * with name and arguments
     * @param attrs  array of 'Command' objects in xml representation
     * @return name of the command and it arguments as ArrayList<String>
     */
    private ArrayList<String> read(NamedNodeMap attrs) {
        ArrayList <String> tempList = new ArrayList<>();
        tempList.add(attrs.getNamedItem("name").getNodeValue());
        tempList.add(attrs.getNamedItem("variable").getNodeValue());
        if (tempList.get(0).equals("open")) {
            tempList.add(attrs.getNamedItem("timeout").getNodeValue());
        }
        return tempList;
    }
}
