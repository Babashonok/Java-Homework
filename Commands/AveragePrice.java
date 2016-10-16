package bsu.tat.products;

/**
 * find average price of all products
 * (sum(Price*amount)/sum(amount)
 */
public class AveragePrice extends ParentCommand {
    private String commandName ="average price";

    /**
     * inherit classes will peform operations which
     * user inputs in the command line     *
     * @param product
     * @return
     */
    @Override
    public void pefrormOperation(ProductData [] product) {
        int amount = 0;
        double totalPrice =0;
        for (ProductData temp : product) {
            amount = amount + temp.getAmount();
            totalPrice = totalPrice +temp.getAmount()*temp.getPrice();
        }
        double average = totalPrice/amount;
        System.out.println(message()+average);

    }

    /**
     * add text information to the performOperation method     *
     * @return
     */
    @Override
    public String message() {
        return "average price is ";
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
