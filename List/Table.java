package tat.bsu.ip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * class that designs an IP table and sends it to the HTMLReport
 */
public class Table {

    private List<Integer> pings = new ArrayList<>();
    private ArrayList<String> ip = new ArrayList<>();
    private final int maxPossiblePing = 500;
    private final int minPossiblePing = 20;
    private int maxPing;

    /**
     * Constructor that creates pings List, ip List
     * and initialize maxPing variable
     * works with command line and File
     * @param output IP Storage
     * @param args input from command line
     */
    public Table(String[] args,BufferedReader output) throws IOException {

        if (args.length > 0) {
            getIPFromFromCommandLine(args);
        } else {
            getIPFromFile(output);
        }
        maxPing = findMaxPing();

    }

    /**
     * @return largest element in the List
     */
    public int findMaxPing() {
        int tempMax = 0;
        for(Integer temp : pings) {
            if (temp > tempMax) {
                tempMax = temp;
            }
        }
        return tempMax;
    }

    /**
     * @return amount of IPs
     */
    public int getListLength() {
        return ip.size();
    }

    /**
     * create list of IPs and pings using file reading
     * @param output IP Storage
     * @throws IOException if file doesn't exist
     */
    public void getIPFromFile(BufferedReader output) throws IOException {
        int code = 0;
        Random random = new Random();
        String temp;
        while ((temp = output.readLine()) != null) {
            pings.add(code, random.nextInt(maxPossiblePing - minPossiblePing + 1) + minPossiblePing);
            ip.add(code, temp);
            code++;
        }
    }
    /**
     * create list of IPs and pings using command line input
     * @param args input from command line
     */
    public void getIPFromFromCommandLine(String [] args) {
        Random random = new Random();
        for (int code = 0 ; code <args.length ; code++ ) {
            pings.add(code, random.nextInt(maxPossiblePing - minPossiblePing + 1) + minPossiblePing);
            ip.add(code, args[code]);
            code++;
        }
    }

    /**
     * create a complete string form with colors
     * @param hash counter of ipes
     * @return String[hash] format
     */
    public  String formString(int hash) {
        if (pings.get(hash)==maxPing) {
            return "<tr>"+System.lineSeparator() + "<td bgcolor = "+"#FF0000> "+ ip.get(hash)+"</td>"
                    +"<td bgcolor = "+"#FF0000> "+ pings.get(hash)+" </td>" +System.lineSeparator()+"</tr>" +System.lineSeparator();
        }
        if (hash % 2 != 0) {
            return "<tr>"+System.lineSeparator() + "<td bgcolor = "+"#D9D9D9> "+ ip.get(hash)+"</td>"
                    +"<td bgcolor = "+'"'+"#D9D9D9"+'"'+">"+ pings.get(hash)+" </td>" +System.lineSeparator()+"</tr>" +System.lineSeparator();
        }
        return "<tr>"+System.lineSeparator() + "<td bgcolor = "+"#EFEFEF> "+ ip.get(hash)+" </td>"
                +"<td bgcolor = "+"#EFEFEF> "+ pings.get(hash)+" </td>" +System.lineSeparator()+"</tr>" +System.lineSeparator();
    }

}
