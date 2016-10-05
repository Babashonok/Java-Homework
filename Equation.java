import static java.lang.Math.*;
import java.lang.NumberFormatException;

/**
 * solve the quadratic equation
 * @author Babak Alexey
 */
public class Equation {

   
   /**
    * Finds a roots of equation.
    * @param coeff Quadric equation coefficients
    */
   public static void solveEquation(double [] coeff) {      
      double discr = pow(coeff[1],2.0) - 4*coeff[0]*coeff[2];       
      if (discr < 0) {
         System.out.println("Negative discriminant");
         System.exit(1);
      } else {         
         double x1 = (-coeff[1] + sqrt(discr))/(2*coeff[0]);
         double x2 = (-coeff[1] - sqrt(discr))/(2*coeff[0]);	
         System.out.println("x1 = " + x1 +" x2 = " + x2);
      }
   }
   /**
    * Find possible errors
    * @param coeff quadric equation coefficients
    * @param length number of coefficients
    */
   public static void checkErrors(int length,double [] coeff) {
      if (length != 3) {
         System.out.println("Try to input 3 numbers (a,b,c)");
         System.exit(1);
      }      
      for (int i = 0; i < length ; i++) {
         if (abs(coeff[i]) < Double.MIN_VALUE || abs(coeff[i]) > Double.MAX_VALUE){
            System.out.println("Try to input 3 numbers in double range");
            System.exit(1);
         }
      }
   } 
   /**
    * parse  arguments to double
    * @param args parameters , which you should input in command line
    */    
   public static double [] checkArgs(String [] args) {
      double [] coeff = new double[args.length];
      for (int i = 0; i < args.length ; i++) {
         coeff[i] = Double.parseDouble(args[i]);
      }
      return coeff;
   }
 
   /** 
    * solve the quadratic equation 
    * @param args parameters , which you should input
    * in command line
    */
   public static void main(String [] args) {
      double [] coeff = new double[args.length];      
      try {
         coeff = checkArgs(args);
      } catch (NumberFormatException e) {
         System.err.println("NumberFormatException" + e.getMessage() + " try to input decimal numbers");          
         System.exit(1);                  
      }
      checkErrors(args.length,coeff);
      solveEquation(coeff);
   }
}