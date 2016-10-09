package bsu.tat.rules;

import java.util.Scanner;
/**
 * check text for compliance to 4 rules
 * no digit, all digit, >5 words, dictionary word
 * @author Babak Alexey
 */
public class Rules {

    public static final int amountOfRules = 4;

    /**
     * convert Scanner line to string
     * @return
     */
    public static String convertScanner() {
        Scanner var = new Scanner(System.in);
        return var.nextLine();
    }

    /**
     * makes the array of inheritor objects
     * @param convertScanner
     * @return
     */
    public static ParentRule [] initialize(String convertScanner) {
        ParentRule [] rulesArray = new ParentRule[amountOfRules];
        rulesArray[0] = new NoDigitRule(convertScanner);
        rulesArray[1] = new AllDigitRule(convertScanner);
        rulesArray[2] = new FiveMoreWordsRule(convertScanner);
        rulesArray[3] = new DictionaryRule(convertScanner);
        return rulesArray;
    }

    /**
     * output information about rules
     * @param rulesArray the array of inheritor objects
     */
    public static void output(ParentRule [] rulesArray) {
        boolean atLeastOneConfirms = false;
        for (int i = 0; i < rulesArray.length ; i++ ) {
            if (rulesArray[i].checkRule()) {
                System.out.println(rulesArray[i].getConfirm());
                atLeastOneConfirms = true;
            }
        }
        if (!atLeastOneConfirms) {
            System.out.println("this text doesn't confirms any rule ");
        }
    }

    /**
     * entry point of the program
     * @param args
     */
    public static void main(String [] args) {
        System.out.println("Please, input something");
        ParentRule [] rulesArray = initialize(convertScanner());
        output(rulesArray);
    }
}
