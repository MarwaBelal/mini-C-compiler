/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicompiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.util.Pair;


public class MiniCompiler {

    private static final String FILENAME = "C:\\Users\\LENOVO\\Desktop\\REs.txt";
        
    public static void main(String[] args) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("C:\\Users\\LENOVO\\Desktop\\dicussion.txt")));
        List<token> tokens = new ArrayList<token>();
                String record;
                String regex[];
                    Scanner s = new Scanner(new File(FILENAME));
                     while (s.hasNextLine()) {
                    record = s.nextLine();
                    regex = record.split(" ");
                          Pattern pattern = Pattern.compile(regex[0]);
                        Matcher matcher = pattern.matcher(data);
                        int x =0 ;
                    while (matcher.find()) {  
                        x++;
                        //System.out.println("Found a match: " +matcher.group(0) +" : "+regex[1]) ;
                        int start = matcher.start();
                        int end  = matcher.end();
                        String o="";
                        if (data.length()>end)
                        o = data.substring(start,end);
                        else o = data.substring(start,data.length());
                        String k = "";
                        k = data.substring(0, start);
                        for (int a = 0 ; a < o.length() ; a++)
                        {
                            k = k + " ";
                        }
                        //System.out.println(data);
                        k = k + data.substring(end,data.length());
                        //System.out.println(k);
                        data = k ;
                        token t = new token();
                        t.str = o.trim();
                        t.token=regex[1];
                        t.strt = start;
                        tokens.add(t);
                        //System.out.println(o);
                        //System.out.println(start);
                    }
                      
                
        }
        
        Collections.sort(tokens, new Comparator<token>(){
            
  @Override
  public int compare(token o1, token o2)
  {
     return o1.strt - o2.strt;
  }
});
    PrintWriter out = new PrintWriter("C:\\Users\\LENOVO\\Desktop\\outputt.txt");
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).str);
            System.out.print(" : ");
            System.out.println(tokens.get(i).token);
            out.println(tokens.get(i).str + " : " + tokens.get(i).token);
            
        }
    String error[];
        error = data.split(" ");
        for (int i = 0; i < error.length; i++) {
            if (!error[i].trim().equals(""))
            System.out.println(error[i].trim() + ": <error:couldn't match>");
            out.println(error[i].trim() + ": <error:couldn't match>");
        }
        out.close();

}
}
