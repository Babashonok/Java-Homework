package tat.bsu.dir;

import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * separate information about files according task requirements
 * and translate it to the HTMLReport
 */
public class FilesHandler {

    private String [] files;
    /**
     * fill array of file names
     * @param directory root of .java, html and testing files and directories
     */
    public void getFileList(File directory) {
        files = directory.list();
    }
    /**
     * @return number of files in current directory
     */
    public int getAmountofFiles() {
        return files.length;
    }

    /**
     * @param hash counter of files in directory
     * @return chosen file
     */
    public String getOneFile(int hash) {
        return files[hash];
    }
    public String getType(File file) {
        if (file.isDirectory()) {
            return "DIR";
        }
        return "FILE";
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
            return "<tr>"+System.lineSeparator() + "<td bgcolor = " + "#EFEFEF> " + files[hash] + "</td>"
                    + "<td bgcolor = " + '"' + "#EFEFEF" + '"' + ">" + getType(new File(curDir+File.separator+files[hash])) + " </td>"
                    + "<td bgcolor = " + '"' + "#EFEFEF" + '"' + ">" + convertData(attrs) + " </td>"
                    + "<td bgcolor = " + '"' + "#EFEFEF" + '"' + ">" + findSize(new File(curDir+File.separator+files[hash]), attrs)+" </td>"
                    + System.lineSeparator() + "</tr>" + System.lineSeparator();
        }
        return "<tr>"+System.lineSeparator() + "<td bgcolor = " + "#F7F7F7> " + files[hash] + "</td>"
                + "<td bgcolor = " + '"' + "#F7F7F7" + '"' + ">" + getType(new File(curDir+File.separator+files[hash])) + " </td>"
                + "<td bgcolor = " + '"' + "#F7F7F7" + '"' + ">" + convertData(attrs) + " </td>"
                + "<td bgcolor = " + '"' + "#F7F7F7" + '"' + ">" + findSize(new File(curDir+File.separator+files[hash]), attrs) + " </td>"
                + System.lineSeparator() + "</tr>" + System.lineSeparator();
    }

    /**
     * find size of files or directories
     * size of directory is the sum of all files in it
     * @param file  chosen file from current directory
     * @param attrs class that provides additional methods to work with files
     * @return
     */
    public double findSize(File file, BasicFileAttributes attrs) {
        if (file.isDirectory()) {
            long size = 0;
            for (File temp : file.listFiles()) {
                if (temp.isFile()) {
                    size += temp.length();
                } else {
                    size += findSize(temp, attrs);
                }
            }
            return (double)size / 1024;
        }
        return (double)attrs.size() / 1024;
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
}
