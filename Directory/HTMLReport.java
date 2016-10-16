package tat.bsu.dir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import static tat.bsu.dir.Directory.absolutePackagePath;

/**
 * Construct HTML page
 * add special formats to strings of the table
 */
public class HTMLReport {
    private final String header = "<HTML>"+System.lineSeparator()+"<TITLE>Current Directory</TITLE>" +System.lineSeparator()+"<HEAD>"
            +System.lineSeparator()+"<meta charset="+"utf-8"+">"+System.lineSeparator();

    private final String tableStyle = "<STYLE>"+System.lineSeparator()+"table {"+System.lineSeparator()
            +"border-collapse: collapse;"+System.lineSeparator()+"} td, th {"
            +System.lineSeparator()+"border: 1px solid #E7E7E7;"+System.lineSeparator()
            +"} th {" +System.lineSeparator()+"background: #CECFCE;"+System.lineSeparator();

    private final String endOfHeader = "</STYLE>"+System.lineSeparator()+"</HEAD>"+System.lineSeparator()
            +"<BODY  bgcolor=\"white\">"+System.lineSeparator()+"<table width = "+'"'+" 400" +'"' +'>'
            + System.lineSeparator();

    private final String footer = "</table>"+System.lineSeparator()+"</BODY>"+System.lineSeparator()+"</HTML>";

    private final String tableCaption = "<tr>" + System.lineSeparator() + "<th><b>ИМЯ</b></th> " + System.lineSeparator()
            + "<th><b>ТИП</b></th> " + System.lineSeparator() + "<th><b>ДАТА СОЗДАНИЯ</b></th> " + System.lineSeparator()
            + "<th><b>РАЗМЕР (в Kb)</b></th> " + System.lineSeparator() + "</tr>"+ System.lineSeparator();

    private String [] files;
    private String [] type ;

    /**
     * copmose HTML page by pieces      *
     * @param input html page
     * @param curDir path to the IDE Project
     * @param directory root of .java, html and testing files and directories
     * @throws IOException if file cannot be created
     */
    public void createPage(String curDir,File directory, FileWriter input) throws IOException {
        getFileList(directory);
        getFileType(curDir);
        input.write(getHeader());
        input.write(getTableStyle());
        input.write(getEndOfHeader());
        input.write(getTableCaption());
        for (int i =0 ; i <files.length ; i++) {
            Path file = Paths.get(curDir+absolutePackagePath+files[i]);
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            input.write(formString(curDir,i,attrs));
        }
        input.write(getFooter());
    }

    /**
     * fill array of file names
     * @param directory root of .java, html and testing files and directories
     */
    public void getFileList(File directory) {
         files = directory.list();
    }

    /**
     * fill array of file type(FILE or Directory)
     * @param curDir path to the IDE Project
     */
    public void getFileType(String curDir) {
        type = new String[files.length ];
        for (int i =0 ; i <type.length ; i++) {
            if (new File(curDir+absolutePackagePath+files[i]).isAbsolute()) {
                type[i] = "FILE";
            }
            if (new File(curDir+absolutePackagePath+files[i]).isDirectory()) {
                type[i] = "DIR";
            }
        }
    }
    /**
     * create a complete string form with colors
     * @param hash counter of files or directories in root dir
     * @param attrs class that provides additional methods to work with files
     * @param curDir path to the IDE Project
     * @return
     */
    public  String formString(String curDir,int hash, BasicFileAttributes attrs) {
        if (hash % 2 != 1) {
            return "<tr>"+System.lineSeparator() + "<td bgcolor = "+"#EFEFEF> "+files[hash] +"</td>"
                    +"<td bgcolor = "+'"'+"#EFEFEF"+'"'+">"+ type[hash]+" </td>"
                    +"<td bgcolor = "+'"'+"#EFEFEF"+'"'+">"+ convertData(attrs)+" </td>"
                    +"<td bgcolor = "+'"'+"#EFEFEF"+'"'+">"+ findLength(hash,new File(curDir+absolutePackagePath+files[hash]),attrs)+" </td>"
                    +System.lineSeparator()+"</tr>" +System.lineSeparator();
        }
        return "<tr>"+System.lineSeparator() + "<td bgcolor = "+"#F7F7F7> "+files[hash] +"</td>"
                +"<td bgcolor = "+'"'+"#F7F7F7"+'"'+">"+ type[hash]+" </td>"
                +"<td bgcolor = "+'"'+"#F7F7F7"+'"'+">"+ convertData(attrs)+" </td>"
                +"<td bgcolor = "+'"'+"#F7F7F7"+'"'+">"+ findLength(hash,new File(curDir+absolutePackagePath+files[hash]),attrs)+" </td>"
                +System.lineSeparator()+"</tr>" +System.lineSeparator();
    }

    /**
     * find size of files or directories
     * size of directory is the sum of all files in it
     * @param hash counter of files or directories in root dir
     * @param directory root of .java, html and testing files and directories
     * @param attrs class that provides additional methods to work with files
     * @return
     */
    public double findLength(int hash,File directory,BasicFileAttributes attrs) {
        if (type[hash].equals("DIR")) {
            long size = 0;
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    size += file.length();
                }
                else
                    size += findLength(hash,file,attrs);
            }
            return (double)size/1024;
        }
        return (double)attrs.size()/1024;
    }

    /**
     * convert date to the dd mm yyyy format
     * @param attrs class that provides additional methods to work with files
     * @return
     */
    public String convertData(BasicFileAttributes attrs) {
        FileTime date = attrs.creationTime();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(date.toMillis());
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
