package commands;

import org.openqa.selenium.WebDriver;
import reports.TestReport;
import java.util.ArrayList;

/**
 * abstract parent class for all kinds of commands
 * has abstract performCommand method that should be override by inherited classes
 */
public abstract class Command {

    boolean isPerformed;
    ArrayList <String> inputCommand;
    double timeSpend;
    /**
     * take string representation of a request with arguments
     * and emulate it using Selenium WebDriver
     */
    public abstract void performCommand(ArrayList <String> inputCommand, WebDriver driver);

    /**
     * @return name of command
     */
    public abstract String getName();

    /**
     * create a TestReport object with data about performed command(success, time spend, arguments)
     * @return report about performed command
     */
    public  TestReport createReport() {
        return new TestReport(isPerformed, inputCommand , timeSpend);
    }

    /**
     * find time spend to perform command
     * @param start System time in the start of performing
     * @param end System time in the end of performing
     */
    public void setTimeSpend(long start, long end) {
        this.timeSpend  = ((double)end - (double)start)/1000;
    }




}
