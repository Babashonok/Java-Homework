package tat.bsu.dir;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Construct HTML page as a table of files in current directory
 * add special formats to strings of the table
 */
public class HTMLReport {
    private final String header = "<HTML>" + System.lineSeparator() + "<TITLE>Current Directory</TITLE>" + System.lineSeparator() + "<HEAD>"
            + System.lineSeparator() + "<meta charset=" + "utf-8" + ">" + System.lineSeparator();

    private final String tableStyle = "<STYLE>" + System.lineSeparator() + "table {" + System.lineSeparator()
            + "border-collapse: collapse;" + System.lineSeparator() + "} td, th {"
            + System.lineSeparator() + "border: 1px solid #E7E7E7;" + System.lineSeparator()
            + "} th {" + System.lineSeparator() + "background: #CECFCE;" + System.lineSeparator();

    private final String endOfHeader = "</STYLE>" + System.lineSeparator() + "</HEAD>" + System.lineSeparator()
            + "<BODY  bgcolor=\"white\">" + System.lineSeparator() + "<table width = " + '"' + " 400"  + '"' + '>'
            + System.lineSeparator();

    private final String footer = "</table>"+System.lineSeparator()+"</BODY>"+System.lineSeparator()+"</HTML>";

    private final String tableCaption = "<tr>" + System.lineSeparator() + "<th><b>РРњРЇ</b></th> " + System.lineSeparator()
            + "<th><b>РўРРџ</b></th> " + System.lineSeparator() + "<th><b>Р”РђРўРђ РЎРћР—Р”РђРќРРЇ</b></th> " + System.lineSeparator()
            + "<th><b>Р РђР—РњР•Р  (РІ Kb)</b></th> " + System.lineSeparator() + "</tr>"+ System.lineSeparator();
    /**
     * copmose HTML page by pieces      *
     * @param input html page
     * @param curDir path to the IDE Project
     * @param directory root of .java, html and testing files and directories
     * @throws IOException if file cannot be created
     */
    public void createPage(String curDir, File directory, PrintWriter input) throws IOException {
        FilesHandler handler = new FilesHandler();
        handler.getFileList(directory);
        input.write(getHeader());
        input.write(getTableStyle());
        input.write(getEndOfHeader());
        input.write(getTableCaption());
        for (int i =0 ; i <handler.getAmountofFiles() ; i++) {
            Path file = Paths.get(curDir + File.separator + handler.getOneFile(i));
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            input.write(handler.formString(curDir, i, attrs));
        }
        input.write(getFooter());
    }


    /**
     * @return header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @return footer
     */
    public String getFooter() {
        return footer;
    }
    /**
     * @return table style
     */
    public String getTableStyle() {
        return tableStyle;
    }
    /**
     * @return end of header
     */
    public String getEndOfHeader() {
        return endOfHeader;
    }
    /**
     * @return table caption
     */
    public String getTableCaption() {
        return tableCaption;
    }

}
