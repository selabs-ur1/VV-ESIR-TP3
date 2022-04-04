package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Assert;

class StringUtilsTest {


    @Test
    public void correct_string() {
    	assertTrue(StringUtils.isBalanced(get_correct_string()));
    }
    
    @Test
    public void incorrect_string() {
    	assertFalse(StringUtils.isBalanced(get_incorrect_string()));
    }

    private static String get_incorrect_string(){
    	int n = 10;
        // chose a Character random from this String
        String OpeningSymbols = "({[";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(OpeningSymbols.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(OpeningSymbols
                          .charAt(index));
        }
  
        return sb.toString();
    }
    private static String get_correct_string(){
    	int n = 10;
        // chose a Character random from this String
        String OpeningSymbols = "({[";
        String ClosingSymbols = ")}]";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(OpeningSymbols.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(OpeningSymbols
                    .charAt(index));
            sb.append(ClosingSymbols
                    .charAt(index));
        }
  
        return sb.toString();
    }
}
