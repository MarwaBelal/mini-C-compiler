/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilers.pkg1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javafx.util.Pair;
import java.lang.Object;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Nagham
 */
public class Compilers1 {

    private static final String FILENAME = "C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\REs.txt";

    public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
    
    public static void main(String[] args) throws Exception {
        String input = readFileAsString("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\test.txt");
        ArrayList<Pair<String, String>> output = new ArrayList<Pair<String, String>>();
        BufferedReader br = null;
        FileReader fr = null;
        List<String> sInput = new ArrayList<String>();
        /*String input = "bool isPowerOfTwo (int x)\n"
                + "{ \n"
                + "// First x in the below expression is\n"
                + "// for the case when x is 0\n"
                + "return x || ( !(x & (x - 1))) x;\n"
                + "<<}";*/
        String x[];
        System.out.println(input);
        String lines[] = input.split("\n|(?<=\\n)");
        int counter = 0;
        for (int i = 0; i < lines.length; i++) {
            System.out.println("mariam");
            System.out.println(i + lines[i]);
            if (lines[i].contains("//")) {
                System.out.println("nagham");
                sInput.add(lines[i]);
                continue;
            }
            x = lines[i].split("(?<=\\(|\\[|\\{|=|\\+|-|/|\\*|!)|(?=\\)|\\]|\\}|=|\\+|-|/|\\*|!)|(?=\\;)|(?=\\,)|( |$)(?=(([^\"]*\"){2})*[^\"]*$)|(?=(([^\']*\'){2})*[^\']*$)( |$) ");
            for (int j = 0; j < x.length; j++) {
                System.out.println("feeeen");
                System.out.println(x[j]);
                sInput.add(x[j]);
            }
          

        }
        for (int i = 0; i < sInput.size(); i++) {
            sInput.set(i, sInput.get(i).trim());
            System.out.println(sInput.get(i));
        }

        for (int i = 0; i < sInput.size(); i++) {
            try {
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
                String sCurrentLine;
                String record;
                String regex[];
                while ((record = br.readLine()) != null) {
                    regex = record.split(" ");
                    Pattern pattern = Pattern.compile(regex[0]);
                    Matcher matcher = pattern.matcher(sInput.get(i));

                    if (matcher.find()) {
                        output.add(new Pair<String, String>(sInput.get(i), regex[1]));
                        break;
                    }
                }

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                    if (fr != null) {
                        fr.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
            }

        }

        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i).getKey());
            System.out.print(" : ");
            System.out.println(output.get(i).getValue());
        }
        System.out.println(output.size());
        System.out.println(sInput.size());

    }
}
