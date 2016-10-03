import java.util.Scanner;
/**
 * find type of the triangle
 * @author Babak Alexey
 */
public class Triangle {
   /** 
    * find equalites between sides
    * @param num0
    * @param num1
    * @param num2 all 3 are represent triangle sides
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
      Scanner var = new Scanner(System.in);
      System.out.println("input 3 numeric lengths");
      int numOfSizes = 3; 
      Double [] side = new Double[numOfSizes];
         for (int i = 0 ; i < numOfSizes ; i++) {	  
         if (var.hasNextDouble() ) {  
            side[i]= var.nextDouble();      
         } else {
            System.out.println("wrong input, try to input 3 numbers");
            System.exit(0);
         }
         if (side[i] <= 0) {
            System.out.println("wrong input, try to input positive numbers");
            System.exit(0);
         }
      }
      if ((side[0] >= side[1]+side[2]) ||(side[1] >= side[0]+side[2])||(side[2] >= side[1]+side[0])) {
         System.out.println("one side larger than sum of others, try again");
         System.exit(0);
      } else {
	 checkType(side[0] , side[1], side[2]);  
      }
   }      
}
