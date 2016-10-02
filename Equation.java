import static java.lang.Math.*;
/**
 * solve the quadratic equation
 * Babak Alexey
 */
public class Equation {

   /** check possibility of the "String -> Double" conversion */
   public static boolean checkString(String string) {
      try {
         Double.parseDouble(string);
      } catch (Exception e) {
           return false;
      }
      return true;
   }

   /** solve the quadratic equation */
   public static void main(String [] args) {
      if(args.length != 3) {
         System.out.println("Try to input 3 numbers ( a,b,c)");
      } else if(!checkString(args[0]) || !checkString(args[1])|| !checkString(args[2])) {
         System.out.println("Try to input 3 NUMBERS");
      }
      double a = Double.parseDouble(args[0]);
      double b = Double.parseDouble(args[1]);
      double c = Double.parseDouble(args[2]);      
      double discr = pow(b,2.0) - 4*a*c; //find discriminant
      if(discr < 0) {
         System.out.println("Negative discriminant");
      } else if(a != 0){
         double x1 = (-b + sqrt(discr))/(2*a);
         double x2 = (-b - sqrt(discr))/(2*a);	
         System.out.println("x1 = " + x1 +" x2 = " + x2);
      } else System.out.println("it is a linearic equation, try to input coeff a!= 0");
   }
}
