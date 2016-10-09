package bsu.tat.rules;

/**
 * inherit class that check all digit
 */
public class AllDigitRule extends ParentRule {


    /**
     * inherit constructor
     * @param text
     */
    public AllDigitRule(String text) {
        super(text);
    }
    /**
     * return confirment of all digit
     * @return
     */
    @Override
    public  boolean checkRule(){
        if (charForm.length == 0) {
            return false;
        }
        for (char temp : charForm) {
            if ( temp < 48 || temp > 57 ) {
                return false;
            }
        }
        return true;
    }
    /**
     * method that return message about rules to the user
     * @return
     */
    @Override
    public  String getConfirm() {
        return "this text has only digits";
    }
}
