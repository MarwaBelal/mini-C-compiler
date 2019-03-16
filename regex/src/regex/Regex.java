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
        String regex = "INT";
        String sentence = "int i = 5";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);
        while(matcher.find())
        {
            System.out.println("first: "+matcher.group());
            System.out.println("first: "+matcher.group(1));
            System.out.println("first: "+matcher.group(2));
        }
    
    }
    
}
