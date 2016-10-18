package tat.bsu.ip;


import java.io.*;
import java.util.ArrayList;


/**
 * Create HTML page that has table about IP and pings
 * Finds the highest ping and mark IP
 * @author Alexey Babak
 */
public class IPList {
    public static final String absolutePackagePath =File.separator + "src"+File.separator + "tat" +
                                                    File.separator + "bsu" + File.separator + "ip" + File.separator ;
    public static ArrayList<Server> servers = new ArrayList<>();
    /**
     * Entry point of the program
     * create file and open another to read
     * @param args input from command line
     * @throws IOException if file cannot be created
     */
    public static void main(String [] args) throws IOException {
        String curDir = System.getProperty("user.dir");
        File file = new File(curDir + absolutePackagePath + "file.html");
        BufferedReader output = new BufferedReader(new InputStreamReader(new FileInputStream(curDir + absolutePackagePath + "IPStorage.txt")));
        FileWriter input = new FileWriter(file);
        HTMLReport report = new HTMLReport();
        ServerList listCreater = new ServerList();

        if (args.length > 0) {
            listCreater.getIPFromFromCommandLine(args, servers);
        } else {
            listCreater.getIPFromFile(output, servers);
        }

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            report.createPage(servers, input);
        } catch (IOException e) {
            System.out.println("file cannot be created");
        }
        input.close();
        output.close();
    }
}
