package bsu.tat.products;

/**
 * Command that foce termination of whole program
 */
public class ExitFromProject extends ParentCommand {

    private String commandName ="exit";


    /**
     * inherit classes will peform operations that
     * user inputs in the command line
     *
     * @param product
     * @return
     */
    @Override
    public void pefrormOperation(ProductData [] product) {
        System.out.println(message());
        System.exit(0);
    }

    /**
     * add text information to the performOperation method
     *
     * @return
     */
    @Override
    public String message() {
        return "Forced Termination";
    }
    /**
     * check whether the user has entered the name
     * of this command
     * @return
     */
    @Override
    public  boolean isCalling(String inputString) {
        return (this.commandName.equals(inputString));
    }
}
