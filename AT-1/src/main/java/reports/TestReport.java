package reports;

import java.util.ArrayList;

/**
 * Report of any performed command
 */
public class TestReport {

    private boolean isPerformed;
    private String message;
    private double timeSpend;

    /**
     * Consturctor that take arguments after command perform
     * and initialize local fields with necessary arguments
     * @param isPerformed mark about result of command perform
     * @param inputCommand list with command name and arguments
     * @param timeSpend time of command perform
     */
    public TestReport(boolean isPerformed, ArrayList<String> inputCommand, double timeSpend) {
        this.isPerformed =isPerformed;
        this.timeSpend = timeSpend;
        this.message = createMessage(isPerformed, inputCommand, timeSpend);
    }

    /**
     * create  format of report that will use in LogFileBuilder
     * @param isPerformed mark about result of command perform
     * @param inputCommand list with command name and arguments
     * @param timeSpend time of command perform
     * @return formatted message
     */
    private String createMessage(boolean isPerformed, ArrayList<String> inputCommand, double timeSpend){
        String mark = "+";
        if (!isPerformed) {
            mark = "!";
        }
        return mark + " [" + createCommandMessage(inputCommand) + "]" + timeSpend;
        }

    /**
     * format list of input command to String line
     * @param inputCommand list with command name and arguments
     * @return String representation of inputCommand arrayList
     */
    private String createCommandMessage(ArrayList<String> inputCommand) {
        String commandMessage = inputCommand.get(0);
        for (int i = 1; i < inputCommand.size(); i++) {
            commandMessage = commandMessage + " " + inputCommand.get(i);
        }
        return commandMessage;
    }

    /**
     * @return formatted message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return ark about result of command perform
     */
    public boolean getIsPerformed() {
        return isPerformed;
    }

    /**
     * @return time of command perform
     */
    public double getTimeSpend() {
        return timeSpend;
    }
}
