package bsu.tat.products;

import java.util.ArrayList;

/**
 * Find average price of one input type
 */
public class AverageTypePrice extends ParentCommand {

    private String commandName ="average price ";
    private ArrayList<String> typeList = new ArrayList<>();
    private String chosenType = null;
     /**
     * create unique constructor due special realization of this class methods
     * (find exact type of product and not changing CommandList.java)
     * @param product
     */
    public AverageTypePrice(ProductData [] product) {
        typeList = setTypeArray(product);
    }

    /**
     * inherit classes will peform operations that
     * user inputs in the command line     *
     * @param product
     * @return
     */
    @Override
    public void pefrormOperation(ProductData [] product) {
        int amount = 0;
        double totalPrice =0;
        for (ProductData temp : product) {
            if (temp.getType().equals(chosenType)) {
                amount = amount + temp.getAmount();
                totalPrice = totalPrice +temp.getAmount()*temp.getPrice();
            }
        }
        double average = totalPrice/amount;
        System.out.println(message() + chosenType+" " + average);
    }

    /**
     * create types array for finding similarities with input
     * @param product
     * @return
     */
    private ArrayList<String> setTypeArray(ProductData [] product) {
        for (ProductData temp : product) {
            typeList.add (temp.getType());
        }
         return typeList;
    }

    /**
     * add text information to the performOperation method     *
     * @return
     */
    @Override
    public String message() {
        return "average price of type ";
    }
    /**
     * check whether the user has entered the name
     * of this command
     * @return
     */
    @Override
    public  boolean isCalling(String inputString) {
        for (String temp : typeList) {
            if ((commandName+temp).equals(inputString)) {
                chosenType = temp;
                return true;
            }
        }
        return false;
    }
}
