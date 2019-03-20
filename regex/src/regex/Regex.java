/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mariam
 */
public class Regex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String FLOAT_LITERAL = "[-+]?[0-9]*\\.?[0-9]+";
        String INTEGRAL_LITERAL = "\\b[-+]?[0-9]*\\b";
        String STRING_LITERAL = "\\b\\D+\\b";
        String CHAR_LITERAL = "\\'[a-z]?\\'"; 
        String LEFT_CURLY_B = "[a-zA-Z]}";
        String RIGHT_CURLY_B ="\\{[a-zA-Z]";
        String LEFT_SQUARE_B = "]";
        String RIGHT_SQUARE_B = "\\[";
        String LEFT_ROUND_B = ")";
        String RIGHT_ROUND_B = "\\(";
        String COMMA = "";
        String string = "mariam 017 1.4 'a' {m} [K]( M";
        String subst = "";
        Pattern pattern = Pattern.compile(RIGHT_CURLY_B);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find())
        {
            System.out.println("first: "+matcher.group());
            //System.out.println("first: "+matcher.group(1));
            //System.out.println("first: "+matcher.group(2));
        }

    }

}
