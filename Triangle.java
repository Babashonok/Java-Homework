import java.util.Scanner;
/**
 * find type of the triangle
 * Babak Alexey
 */
public class Triangle {
   //find type of the triangle
   public static void main(String [] args) {
      Scanner var = new Scanner(System.in);
      System.out.println("input 3 numeric lengths");
      int numOfSizes = 3; 
      double [] side = new double[numOfSizes];
	for(int i = 0 ; i < numOfSizes ; i++) {	  
         if(var.hasNextDouble() ) {  
            side[i]= var.nextDouble();      
         } 
         else {
            System.out.println("wrong input, try to input 3 numbers");
            break;
         }
         if(side[i] <= 0) {
            System.out.println("wrong input, try to input positive numbers");
            break;
         }
      }
      if((side[0] >= side[1]+side[2]) ||(side[1] >= side[0]+side[2])||(side[2] >= side[1]+side[0])) {
         System.out.println("one side larger than sum of others, try again");
      }
      //check type
	else if(side[0] == side[1] &&	side[0] == side[2]) {
         System.out.println("it is equilateral triangle");
      }
      else if(side[0] != side[1] && side[0] != side[2] && side[1] != side[2]) {
         System.out.println("it is normal random triangle");
      }
      else	System.out.println("it is isosceles triangle");
   }      
}
