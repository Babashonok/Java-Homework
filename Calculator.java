public class Calculator {

   //check possibility of the "String -> Double" conversion
   public static boolean checkString(String string) {
      try {
         Double.parseDouble(string);
      } catch (Exception e) {
           return false;
      }
      return true;
   }

   //make 4 simpliest math methods(+-*/) with 2 numbers from command line
   public static void main(String [] args) {
      if(args.length != 2) {
         System.out.println("Try to input 2 numbers");
      }
      else if(!checkString(args[0]) || !checkString(args[1])) {
         System.out.println("Try to input 2 NUMBERS");
      }
      else {
         double num1 = Double.parseDouble(args[0]);
         double num2 = Double.parseDouble(args[1]);
         double sum = num1 + num2;
         System.out.println("Sum = " + sum);
         System.out.println("Difference = " + (num1-num2));
         System.out.println("Multiplier = " + num1*num2);
         if(num2 == 0) {
            System.out.println("Dividind by zero");
         }
         else System.out.println("Division = " + num1/num2);			
      }
   }
}
