package reports;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Build log and send it to the .txt file
 */
public class LogFileBuilder {

    /**
     * write to the .txt file all necessary information
     * @param input filled file
     * @param listOfReportsHandler list with all reports
     * @throws IOException if file wasn't created
     */
    public LogFileBuilder(FileWriter input, ListOfReportsHandler listOfReportsHandler) throws IOException {
        for (TestReport report : listOfReportsHandler.getTestReportsList()) {
            input.write(report.getMessage() + "\n");
        }
        input.write(listOfReportsHandler.getNumberOfTests() + "\n");
        input.write(listOfReportsHandler.getTestStatistics() + "\n");
        input.write(listOfReportsHandler.getTotalTime() + "\n");
        input.write(listOfReportsHandler.getAverageTime() + "\n");
    }
}
