package tat.bsu.ip;


import java.util.ArrayList;

/**
 * create properties to  servers : find largest ping server
 * create graffic settings for every server
 */
public class ServersHandler {


    private int maxPing;

    /**
     * @return largest element in the List
     */
    public void findMaxPing(ArrayList<Server> servers) {
        int tempMax = 0;
        for(Server temp :servers) {
            if (temp.getPing() > tempMax) {
                tempMax = temp.getPing();
            }
        }
        this.maxPing = tempMax;
    }

    /**
     * create a complete string form with colors
     * @param hash counter of ipes
     * @return String[hash] format
     */
    public  String formString(Server server, int hash ) {
        if (server.getPing() == maxPing) {
            return "<tr>" + System.lineSeparator() + "<td bgcolor = " + "#FF0000> " + server.getIp() + "</td>"
                    +"<td bgcolor = "+"#FF0000> "+server.getPing() + " </td>" +System.lineSeparator() + "</tr>" + System.lineSeparator();
        }
        if (hash % 2 != 0) {
            return "<tr>" + System.lineSeparator() + "<td bgcolor = " + "#D9D9D9> " + server.getIp() + "</td>"
                    + "<td bgcolor = " + '"' + "#D9D9D9" + '"' + ">" + server.getPing() + " </td>" + System.lineSeparator() + "</tr>" + System.lineSeparator();
        }
        return "<tr>" + System.lineSeparator() + "<td bgcolor = " + "#EFEFEF> " + server.getIp() + " </td>"
                + "<td bgcolor = " + "#EFEFEF> " + server.getPing() + " </td>" + System.lineSeparator() + "</tr>" + System.lineSeparator();
    }

}