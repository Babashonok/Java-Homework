package dataHandlers;

import commands.ListOfCommands;


import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;

import java.io.File;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Read information from .json files and handle it
 * also can send report about every command
 */
public class JSONHandler extends FileHandler implements Reportable{
    /**
     * @return extension, which this class can handle
     */
    @Override
    public String getExtension() {
        return ".json";
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
        FileReader fileReader = new FileReader(file);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(fileReader);
        JSONArray jsonCommand = (JSONArray) jsonObject.get("command");
        for (int i = 0; i < jsonCommand.size(); i++) {
            inputCommand = read(jsonCommand, i);
        }
    }

    /**
     * read JSON object arguments from .json file
     * @param jsonCommand JSON element from the array
     * @param i number of the element in the array
     * @return name and arguments of the command as arrayList <String>
     * @throws JSONException exception during Json proccess getting in parsing from file
     */
    private ArrayList<String> read(JSONArray jsonCommand, int i) throws JSONException {
        ArrayList <String> tempList = new ArrayList<>();
        tempList.add(jsonCommand.get(i).toString());        
        tempList.add(jsonCommand.getJSONObject(i).getString("variable"));
        if (tempList.get(0).equals("open")) {
           tempList.add(jsonCommand.getJSONObject(i).getString("timeout"));
        }
        return tempList;
    }
}
