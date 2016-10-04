import java.util.Scanner;
/**
 * find type of the triangle
 * @author Babak Alexey
 */
public class Triangle {
   /**
    * retype Scanner to Double and return the array
    * @param numOfSizes  number of the triangle sides 
    */
   public static Double[] fillDoubleArray(int numOfSizes) {
      Scanner var = new Scanner(System.in);
      Double [] side = new Double[numOfSizes];
      for (int i = 0 ; i < numOfSizes ; i++) {	  
         if (var.hasNextDouble() ) {  
            side[i]= var.nextDouble();      
         } else {
            System.out.println("Try to input every number in decimal type");
            System.exit(1);
         }
      } 
      return side;
   }
   /** 
    * find equalites between sides
    * @param num0  represent triangle side
    * @param num1  represent triangle side
    * @param num2  represent triangle side
    */
   public static void checkType(Double num0 , Double num1 , Double num2) {
      if (num0.equals(num1) && num0.equals(num2)) {
         System.out.println("it is equilateral triangle");
      } else if (!num0.equals(num1) && !num0.equals(num2) && !num1.equals(num2)) {
         System.out.println("it is normal random triangle");
      } else System.out.println("it is isosceles triangle");
   }
   /**
    * find type of the triangle 
    */
   public static void main(String [] args) {      
      System.out.println("input 3 numeric lengths");
      int numOfSizes = 3; 
      Double [] side = fillDoubleArray(numOfSizes);    
    
      for (int i = 0 ; i < numOfSizes ; i++) {	  
         if (side[i] <= 0) {
            System.out.println("wrong input, try to input positive numbers");
            System.exit(1);
         }
      }
      if ((side[0] >= side[1]+side[2]) ||(side[1] >= side[0]+side[2])||(side[2] >= side[1]+side[0])) {
         System.out.println("one side larger than sum of others, try again");
         System.exit(1);
      } else {
	 checkType(side[0] , side[1], side[2]);  
      }
   }      
}
