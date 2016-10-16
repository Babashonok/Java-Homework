package bsu.tat.products;

/**
 * abstract parent class for all commands
 */
public abstract class ParentCommand {

    private String commandName ;

    /**
     * possibility to change command name
     */
    protected  void setCommandName(String changer){
        commandName = changer;
    }

    /**
     * get command name to user
     * @return
     */
    protected String getCommandName(){
        return commandName;
    }
    /**
     * inherit classes will peform operations that
     * user input in the command line
     * @param product
     * @return
     */
    public abstract void pefrormOperation(ProductData [] product);

    /**
     * add text information to the performOperation method
     * @return
     */
    public abstract String message();
    /**
     * check whether the user has entered the name
     * of this command
     * @return
     */
    public  abstract boolean isCalling(String inputString) ;

}
