package dataHandlers;

import reports.ListOfReportsHandler;

/**
 * show that all classes with that interface should realize method sendReport
 */
public interface Reportable {

    /**
     * @return list of reports
     */
    ListOfReportsHandler sendReport();
}
