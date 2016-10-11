package bsu.tat.rules;

/**
 * inherit class that check no digit
 */
public class NoDigitRule extends ParentRule {

    /**
     * inherit constructor
     * @param text
     */
    public NoDigitRule(String text) {
        this.charForm = text.toCharArray();
    }

    /**
     * @return confirment of non digit     
     */
    @Override
    public  boolean checkRule() {
        for (char temp : charForm) {
            if (temp >= 48 && temp <=57) {
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
        return "this text hasn't any digits";
    }

}
