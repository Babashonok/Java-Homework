package tat.bsu.dir;

import java.io.*;
/**
 * Create HTML page that has information about current Directory:
 * name of file , type , creation date and size
 */
public class Directory {
    /**
     * entry point of the program
     * @param args input from command line
     */
    public static void main(String [] args) throws IOException {
        String curDir = new File("").getAbsolutePath();
        String encoding = System.getProperty("console.encoding", "utf-8");
        File file = new File(curDir + File.separator + "file.html");
        File directory = new File(curDir);
        PrintWriter input = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
        HTMLReport report = new HTMLReport();

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            report.createPage(curDir, directory, input);
        } catch (IOException e) {
            System.out.println("file cannot be created");
        }
        input.close();
    }
}