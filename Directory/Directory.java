package tat.bsu.dir;

import java.io.*;

/**
 * Create HTML page that has information about current Directory:
 * name of file , type , creation date and size
 */
public class Directory {
    public static final String absolutePackagePath = File.separator +"src"+File.separator +"tat"+File.separator+"bsu"+File.separator+"dir"+File.separator ;
    /**
     * entry point of the program
     * @param args input from command line
     */
    public static void main (String [] args ) throws IOException {
        String curDir = new File("").getAbsolutePath();
        File file = new File(curDir+absolutePackagePath+"file.html");
        File directory = new File(curDir+absolutePackagePath);
        FileWriter input = new FileWriter(file);
        HTMLReport report = new HTMLReport();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            report.createPage(curDir,directory,input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        input.close();
    }
}
