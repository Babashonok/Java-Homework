import static java.lang.Math.*;
/**
 * solve the quadratic equation
 * @author Babak Alexey
 */
public class Equation {

   /** 
    * check possibility of the "String -> Double" conversion
    * @param string  the string to check,
    * if string has only double variable  - return it
    */
   public static double convertString(String string) {	
      double coeff;
      try {
         coeff = Double.parseDouble(string);
         return coeff ;
      } catch (Exception e) {
         System.out.println("Try to input every number in decimal type");
         System.exit(1);
         return 0;
      }      
   }

   /** 
    * solve the quadratic equation 
    * @param args parameters , which you should input
    * in command line
    */
   public static void main(String [] args) {
	double [] coeff = new double[args.length];
      if (args.length != 3) {
         System.out.println("Try to input 3 numbers ( a,b,c)");
         System.exit(1);
      }      
      for (int i = 0; i < args.length ; i++) {
         coeff[i] = checkString(args[i]);    
         if (abs(coeff[i]) < Double.MIN_VALUE || abs(coeff[i]) > Double.MAX_VALUE){
            System.out.println("Try to input 3 numbers in double range");
            System.exit(1);
         }
      }     
      double discr = pow(coeff[1],2.0) - 4*coeff[0]*coeff[2]; //find discriminant
      double test = 1./coeff[0];
      if (discr < 0) {
         System.out.println("Negative discriminant");
         System.exit(1);
      } else if (!Double.isInfinite(test) || !Double.isInfinite(-test)){
         double x1 = (-coeff[1] + sqrt(discr))/(2*coeff[0]);
         double x2 = (-coeff[1] - sqrt(discr))/(2*coeff[0]);	
         System.out.println("x1 = " + x1 +" x2 = " + x2);
      } else {
         System.out.println("it is a linearic equation, try to input coeff a!= 0");
      }   
   }
}