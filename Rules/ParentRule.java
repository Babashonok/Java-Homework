package bsu.tat.rules;

/**
 * abstract parent class for rules
 */
public abstract class ParentRule {
    
    private char [] charForm;   

    /**
     * abstract method that return confirment of the rules
     * @return
     */
    public abstract boolean checkRule();

    /**
     * abstract method that return message about rules to the user
     * @return
     */
    public abstract String getConfirm();

}
