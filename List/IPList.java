package tat.bsu.ip;

import java.io.*;

/**
 * Create HTML page that has table about IP and pings
 * Finds the highest ping and mark IP
 * @author Alexey Babak
 */
public class IPList {
    public static final String absolutePackagePath = "C:\\Documents and Settings\\Admin\\IdeaProjects\\IPList\\src\\tat\\bsu\\ip\\";

    /**
     * Entry point of the program
     * create file and open another to read
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {
        File file = new File(absolutePackagePath+"file.html");
        BufferedReader output = new BufferedReader(new InputStreamReader(new FileInputStream(absolutePackagePath+ "IPStorage.txt")));
        FileWriter input = new FileWriter(file);
        HTMLReport report = new HTMLReport();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            report.createPage(args,output,input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        input.close();
        output.close();
    }
}
