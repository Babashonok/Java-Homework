/**
 * output string name from command line 
 * @author Babak Alexey
 */
public class SayMeYourName {
   /** 
    *output string name from command line 
    */
   public static void main(String [] args) {
      if (args.length == 0) {
         System.out.println(" Error, try to enter your name next time");
      } else if (args.length > 1) {
         System.out.println("Hello, " + args[0] + ", no need to give additional information");
      } else {
         System.out.println("Hello, " + args[0]);
      }
   }
}
		
