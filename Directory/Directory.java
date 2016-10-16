package tat.bsu.dir;

import java.io.*;

/**
 * Create HTML page that has information about current Directory:
 * name of file , type , creation date and size
 */
public class Directory {
    public static final String absolutePackagePath = "C:\\Documents and Settings\\Admin\\IdeaProjects\\Directory\\src\\tat\\bsu\\dir\\";
    /**
     * entry point of the program
     * @param args
     */
    public static void main (String [] args ) throws IOException {
        File directory = new File(absolutePackagePath);
        File file = new File(absolutePackagePath+"file.html");
        FileWriter input = new FileWriter(file);
        HTMLReport report = new HTMLReport();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            report.createPage(directory,input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        input.close();
    }
}
