import java.util.Scanner;
/**
 * find type of the triangle
 * @author Babak Alexey
 */
public class Triangle {
   /** 
   *find equalites between sides 
   */
   public static void checkType(double num0 , double num1 , double num2) {
      if(num0 == num1 && num0 == num2) {
         System.out.println("it is equilateral triangle");
      } else if(num0 != num1 && num0 != num2 && num1 != num2) {
         System.out.println("it is normal random triangle");
      } else System.out.println("it is isosceles triangle");
   }
   /**
   *find type of the triangle 
   */
   public static void main(String [] args) {
      Scanner var = new Scanner(System.in);
      System.out.println("input 3 numeric lengths");
      int numOfSizes = 3; 
      double [] side = new double[numOfSizes];
	for(int i = 0 ; i < numOfSizes ; i++) {	  
         if(var.hasNextDouble() ) {  
            side[i]= var.nextDouble();      
         } else {
            System.out.println("wrong input, try to input 3 numbers");
            System.exit(0);
         }
         if(side[i] <= 0) {
            System.out.println("wrong input, try to input positive numbers");
            System.exit(0);
         }
      }
      if((side[0] >= side[1]+side[2]) ||(side[1] >= side[0]+side[2])||(side[2] >= side[1]+side[0])) {
         System.out.println("one side larger than sum of others, try again");
         System.exit(0);
      } else {
	 checkType(side[0] , side[1], side[2]);  
      }
   }      
}
