package bsu.tat.rules;

/**
 * inherit class that check 5+ words
 */
public class FiveMoreWordsRule extends ParentRule {

    private char [] separators ={' ','/','.',',','!','?',';',':','-'};
    /**
     * inherit constructor
     * @param text
     */
    public FiveMoreWordsRule(String text) {
        super(text);
    }
    /**
     * transform char string to boolean array according
     * separators array
     * @return
     */
    private boolean [] transformString() {
        boolean [] tempArray = new  boolean [charForm.length];
        for (int i = 0 ; i < separators.length ; i++) {
            for (int j = 0 ; j <charForm.length ; j++) {
                if (charForm[j] == separators[i] ) {
                    tempArray[j] = true;
                }
            }
        }
        return tempArray;
    }
    /**
     * return confirment of 5+ words
     * @return
     */
    @Override
    public  boolean checkRule(){
        int countWords = 0;
        boolean [] tempArray = transformString();
        for (int i = 1 ; i<tempArray.length ; i++) {
            if(tempArray[i] && !tempArray[i-1]) {
                countWords++;
            }
        }
        if (countWords > 5) {
            return true;
        }
        return false;
    }
    /**
     * method that return message about rules to the user
     * @return
     */
    @Override
    public  String getConfirm() {
        return "this text has at least 6 words";
    }
}
