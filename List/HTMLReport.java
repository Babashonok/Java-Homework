package tat.bsu.ip;

import java.io.*;
import java.util.ArrayList;

/**
 * class has only constructor , that collect
 * Strings from HTMLStructure and Table in one page
 */
public class HTMLReport {
    /**
     * copmose HTML page by pieces from HTMLStructure and Table
     * @param servers list of servers
     * @param input html page
     * @throws IOException if file cannot be created
     */
    public void createPage(ArrayList<Server> servers, FileWriter input) throws IOException {
        HTMLStructure report = new HTMLStructure();
        ServersHandler handler  =new ServersHandler();
        handler.findMaxPing(servers);
        input.write(report.getHeader());
        input.write(report.getTableStyle());
        input.write(report.getEndOfHeader());
        input.write(report.getTableCaption());
        for (int i = 0 ; i < servers.size() ; i++) {
            input.write( handler.formString(servers.get(i), i));
        }
        input.write(report.getFooter());

    }
}
