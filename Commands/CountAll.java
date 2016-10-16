package bsu.tat.products;

/**
 * count amount of all products
 */
public class CountAll extends ParentCommand {

    private String commandName = "count all";
    /**
     * inherit classes will peform operations that
     * user inputs in the command line
     * count the amount of all products
     * @param product
     * @return
     */
    @Override
    public void pefrormOperation(ProductData [] product) {
        int sum = 0;
        for (ProductData temp : product) {
            sum = sum + temp.getAmount();
        }
        System.out.println(message()+sum);
    }

    /**
     * add text information to the performOperation method     *
     * @return
     */
    @Override
    public String message() {
        return "total amount of products is ";
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
