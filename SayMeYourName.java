/**
* output string name from command line 
* Babak Alexey
*/
public class SayMeYourName {
   //output string name from command line 
   public static void main(String [] args) {
      if(args.length == 0) {
         System.out.println(" Please,enter your name ");
      }
      else if(args.length > 1) {
         System.out.println("Hello, " + args[0] + ", no need to give additional information");
      }
      else {
         System.out.println("Hello, " + args[0]);
      }
   }
}
		
