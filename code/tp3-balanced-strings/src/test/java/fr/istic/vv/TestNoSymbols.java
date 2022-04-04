package fr.istic.vv;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class TestNoSymbols {

    @Test
    public void no_symbols_string() {
    	assertTrue(StringUtils.isBalanced(getAlphaNumericString()));
    }
    
    private static String getAlphaNumericString(){
    	int n = 10;
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
}
