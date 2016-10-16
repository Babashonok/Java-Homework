package tat.bsu.ip;

import java.io.*;
/**
 * class has only constructor , that collect
 * Strings from HTMLStructure and Table in one page
 */
public class HTMLReport {
    /**
     * copmose HTML page by pieces from HTMLStructure and Table
     * @param args input from command line
     * @param output IP Storage
     * @param input html page
     * @throws IOException if file cannot be created
     */
    public void createPage(String [] args,BufferedReader output, FileWriter input) throws IOException {
        HTMLStructure report = new HTMLStructure();
        Table table  =new Table(args,output);
        input.write(report.getHeader());
        input.write(report.getTableStyle());
        input.write(report.getEndOfHeader());
        input.write(report.getTableCaption());
        for (int i = 0 ; i < table.getListLength(); i++) {
            input.write(table.formString(i));
        }
        input.write(report.getFooter());

    }
}
