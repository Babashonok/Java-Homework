package tat.bsu.ip;
/**
 * build HTML page with constant header and footer
 */
public class HTMLStructure {

    private final String header = "<HTML>" + System.lineSeparator() + "<TITLE>IP List</TITLE>" + System.lineSeparator() + "<HEAD>"
                                  + System.lineSeparator() + "<meta charset=" + "utf-8" + ">" + System.lineSeparator();

    private final String tableStyle = "<STYLE>" + System.lineSeparator() + "table {" + System.lineSeparator()
                                      + "border-collapse: collapse;" + System.lineSeparator() + "} td, th {"
                                      + System.lineSeparator() + "border: 1px solid #FFFFFF;" + System.lineSeparator()
                                      + "} th {" + System.lineSeparator() + "background: #999999;" + System.lineSeparator();

    private final String endOfHeader = "</STYLE>" + System.lineSeparator() + "</HEAD>" + System.lineSeparator()
                                       + "<BODY  bgcolor=\"white\">" + System.lineSeparator() + "<table width = " + '"' + " 400" + '"' +'>'
                                       + System.lineSeparator();

    private final String footer = "</table>" + System.lineSeparator() + "</BODY>" + System.lineSeparator() + "</HTML>";

    private final String tableCaption = "<tr>" + System.lineSeparator() + "<th><b>Server</b></th> " + System.lineSeparator()
                                        + "<th><b>Response,ms</b></th> " + System.lineSeparator() + "</tr>" + System.lineSeparator();

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
