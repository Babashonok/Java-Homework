package bsu.tat.products;

/**
 * Command that find amount of unique types
 */
public class CountTypes extends ParentCommand {
    private String commandName ="count types";

    /**
     * inherit classes will peform operations that
     * user inputs in the command line
     * count amount of types( with the help of typeCode)
     * @param product
     * @return
     */
    @Override
    public void pefrormOperation(ProductData [] product) {
        int amount = 0;
        for (int i = 0 ; i <product.length ; i++) {
            for (int j = 0 ; j <product.length ; j++) {
                if (product[i].getType().equals(product[j].getType()) && !product[i].getTypeCode() && !product[j].getTypeCode() &&i != j ) {
                    product[i].setTypeCode(true);
                }
            }
        }
        for (ProductData temp1 : product) {
            if (!temp1.getTypeCode()) {
                amount++;
            }
        }
        System.out.println(message()+amount);
    }

    /**
     * add text information to the performOperation method
     *
     * @return
     */
    @Override
    public String message() {
        return "Total amount of types = ";
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
