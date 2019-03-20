/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Belal
 */
public class Regex {
    
    public static void main(String[] args) {
    // TODO code application logic here
    String auto_keyword = "\\b(auto)\\b";
    String new_keyword = "\\b(new)\\b";
    String eof_keyword = "\\b(0)\\b";
    String true_keyword = "\\b(true)\\b";
    String false_keyword = "\\b(false)\\b";
    String break_keyword = "\\b(break)\\b";
    String bool_keyword = "\\b(bool)\\b";
    String case_keyword = "\\b(case)\\b";
    String char_keyword = "\\b(char)\\b";
    String const_keyword = "\\b(const)\\b";
    String continue_keyword = "\\b(continue)\\b";
    String default_keyword = "\\b(default)\\b";
    String do_keyword = "\\b(do)\\b";
    String double_keyword = "\\b(double)\\b";
    String else_keyword = "\\b(else)\\b";
    String enum_keyword = "\\b(enum)\\b";
    String extern_keyword = "\\b(extern)\\b";
    String float_keyword = "\\b(float)\\b";
    String for_keyword = "\\b(for)\\b";
    
    /** String keyString = "auto new null true false break bool case " 
                    + "char const continue default do double else "
                    + "enum extern float for ";
    **/
                       
    //String[] keys = keyString.split(" ");
    //String keyStr = StringUtils.join(keys,"|");
    //String regex = "\\b("+keyStr+")\\b";
    String targetString = "auto marwa new mariam true false for ( int i = 0 ; i < 5 ; i++ ) ";
    Pattern pattern = Pattern.compile(for_keyword);
    
    Matcher matcher = pattern.matcher(targetString);
    while(matcher.find())
    {
        System.out.println("Found a match: " + matcher.group());
        System.out.println("Start at position: " + matcher.start());
        System.out.println("End at position: " + matcher.end());
    }
    }
    
}
