package reports;

import dataHandlers.FileHandler;
import dataHandlers.ListOfFileHandlers;

import java.util.ArrayList;

/**
 * List of all reports that was created during this program
 */
public class ListOfReportsHandler {
    private ArrayList<TestReport> testReportsList = new ArrayList<>();
    private double totalTimeSpend;

    /**
     * add new report to the list
     * @param testReport new report
     * @return link to the list
     */
    public ListOfReportsHandler add(TestReport testReport) {
        testReportsList.add(testReport);
        return this;
    }

    /**
     * @return formatted String about total tests info
     */
    public String getNumberOfTests() {
        return "Total tests: " + testReportsList.size();
    }
    /**
     * @return formatted String about positive/negative tests info
     */
    public String getTestStatistics() {
        int passCounter = 0;
        for (TestReport report : testReportsList) {
            if (report.getIsPerformed()) {
                passCounter++;
            }
        }
        return "Passed/Failed: " + passCounter + "/" + (testReportsList.size() - passCounter);
    }
    /**
     * @return formatted String about total time info
     */
    public String getTotalTime() {
        double totalTimeSpend = 0;
        for (TestReport report : testReportsList) {
            totalTimeSpend += report.getTimeSpend();
        }
        this.totalTimeSpend = totalTimeSpend;
        return "Total time: " + String.format("%.3f", this.totalTimeSpend);
    }
    /**
     * @return formatted String about average time info
     */
    public String getAverageTime() {
        return  "Avegare time: " + String.format("%.3f", totalTimeSpend/testReportsList.size());
    }

    /**
     * @return this list
     */
    public ArrayList<TestReport> getTestReportsList() {
        return testReportsList;
    }

}
