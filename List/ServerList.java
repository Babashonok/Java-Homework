package tat.bsu.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * create list of IPs and pings using data from different sources(flies or command line)
 */
public class ServerList {
    /**
     * create list of IPs and pings using file reading
     * @param output IP Storage
     * @throws IOException if file doesn't exist
     */
    public void getIPFromFile(BufferedReader output, ArrayList<Server> servers) throws IOException {
        String temp;
        while ((temp = output.readLine()) != null) {
            servers.add(new Server(temp));
        }
    }
    /**
     * create list of IPs and pings using command line input
     * @param args input from command line
     */
    public void getIPFromFromCommandLine(String [] args, ArrayList<Server> servers) {
        for (int code = 0 ; code <args.length ; code++ ) {
            servers.add(new Server(args[code]));

        }
    }
}
