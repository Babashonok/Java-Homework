/**
 * output parameters from command line in reverse order 
 * Babak Alexey
 */
public class CommandLineParams {
   /** Output parameters from command line in reverse order.  */
   public static void main(String[] args) {
      for(int i = args.length -1; i >= 0 ; i--) {
         System.out.println("Argument " + i + " = " + args[i]);
      }
   }
}
