package bsu.tat.rules;

/**
 * inherit class that check dictionary word
 */
public class DictionaryRule extends ParentRule {

    private String [] Dictionary ={"one","two","three","four","five"};
    /**
     * inherit constructor
     * @param text
     */
    public DictionaryRule(String text) {
        super(text);
    }
    /**
     * return confirment of dictionary word
     * @return
     */
    @Override
    public  boolean checkRule(){
        for (String temp : Dictionary) {
            if (stringForm.contains(temp)) {
                return true;
            }
        }
        return false;
    }
    /**
     * method that return message about rules to the user
     * @return
     */
    @Override
    public  String getConfirm() {
        return "this text has at least 1 word from dictionary";
    }
}
