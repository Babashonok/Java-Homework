package bsu.tat.products;

import  java.util.Scanner;

/**
 * class that contain parameters of product
 */
public class ProductData {

    private String type;
    private String name;
    private int amount;
    private double price;
    private boolean typeCode = false;

    /**
     * constructor
     */
    public ProductData() {
        setType();
        setName();
        setAmount();
        setPrice();
    }
    /**
     * set type from Scanner util
     */
    public void setType() {
        System.out.println("enter product type ");
        Scanner var = new Scanner(System.in);
        this.type = var.nextLine();
    }

    /**
     * get type of product
     * @return
     */
    public String getType(){
        return type;
    }
    /**
     * set name from Scanner util
     */
    public void setName() {
        System.out.println("enter product name ");
        Scanner var = new Scanner(System.in);
        this.name = var.nextLine();
    }
    /**
     * get name of product
     * @return
     */
    public String getName(){
        return name;
    }
    /**
     * set amount from Scanner util
     */
    public void setAmount() {
        System.out.println("enter amount of product ");
        Scanner var = new Scanner(System.in);
        this.amount = var.nextInt();
    }
    /**
     * get amount of product
     * @return
     */
    public int getAmount(){
        return amount;
    }
    /**
     * set price from Scanner util
     */
    public void setPrice() {
        System.out.println("enter product price ");
        Scanner var = new Scanner(System.in);
        this.price =  var.nextDouble();
    }
    /**
     * get price of product
     * @return
     */
    public double getPrice(){
        return price;
    }
    /**
     * set typeCode( additional variable that will
     * used in situations with similar types of
     * two or more products
     * @param changer
     */
    public void setTypeCode(boolean changer) {
        typeCode = changer;
    }
    /**
     * get typeCode
     * @return
     */
    public boolean getTypeCode(){
        return typeCode;
    }

}
