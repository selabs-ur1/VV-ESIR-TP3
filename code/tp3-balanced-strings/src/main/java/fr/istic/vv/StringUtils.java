package fr.istic.vv;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
    if (str == null) return true;
    
    int len = str.length();
    int opened_statements = 0;
    char[] expected_closing_statements = new char[len];
    char expected_closing_statement = '\0';
    
    Character[] array = new Character[len];
    for (int i = 0; i < len ; i++) {
        char current_char = str.charAt(i);
        array[i] = current_char;
        switch(current_char) {
        case '(':
            opened_statements++;
            expected_closing_statements[opened_statements-1] = ')';
            break;
        case '[':
            opened_statements++;
            expected_closing_statements[opened_statements-1] = ']';
            break;
        case '{':
            opened_statements++;
            expected_closing_statements[opened_statements-1] = '}';
            break;
        default:
            break;
        }
        if(opened_statements > 0) expected_closing_statement = expected_closing_statements[opened_statements-1];
        if(current_char == expected_closing_statement) opened_statements--;
    }
    if (opened_statements == 0) return true;
    return false;
    }

}
