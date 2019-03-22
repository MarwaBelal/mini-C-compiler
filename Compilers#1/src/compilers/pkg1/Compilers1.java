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
import java.util.Arrays;

/**
 *
 * @author Nagham
 */
public class Compilers1 {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    private static final String FILENAME = "C:\\Users\\LENOVO\\Desktop\\REs.txt";
    //private static final String FILENAME = "C:\\Users\\LENOVO\\Documents\\GitHub\\mini-C-compiler\\REs.txt";

    public static void main(String[] args) throws Exception {
        String input = readFileAsString("C:\\Users\\LENOVO\\Desktop\\test.txt");
        ArrayList<Pair<String, String>> output
                = new ArrayList<Pair<String, String>>();
        BufferedReader br = null;
        FileReader fr = null;
        //String input = "(if) ( int) static 0 90 111 1nagham nagham3 _1 auto yes-yes 0.0 12 s, m; \"bla bla\" 'z' x1=x2 /x3 int intvalue = 10.0+5;  ";
        //String sInput[] = new String[100];
        List<String> sInput = new ArrayList<String>();
        /*String input = "bool isPowerOfTwo (int x)\n" +
         "{ \n" +
         "// First x in the below expression is\n" +
         "// for the case when x is 0\n" +
         "return x || ( !(x & (x - 1))) x;\n" +
         "<<}";*/
        String x[];
        System.out.println(input);
        //sInput = input.split(" (?<=//)");
        //sInput = input.split("(?=\\))|(?<=\\()|(?<=\")|(?=\")|( |$)(?=(([^\"]*\"){2})*[^\"]*$)");
        String lines[] = input.split("\n|(?<=\\n)");
        int counter = 0;
        String multi = "";
        String temp = "";
        for (int i = 0; i < lines.length; i++) {
            //System.out.println(i + lines[i]);
            if (lines[i].contains("//")) {
                sInput.add(lines[i]);
                continue;
            }
            if (lines[i].contains("/*") && (lines[i].contains("*/"))) {
                sInput.add(lines[i]);
                continue;
            }
            if (lines[i].contains("/*")) {
                multi += lines[i].trim();
                System.out.println("___________________________________________________");
                //System.out.println(multi);  
                for (int j = i + 1; j < lines.length; j++) {
                    counter++;
                    if(lines[j].equals("")){continue;}
                    //System.out.print("j = "+ j);
                    System.out.println("line: " + lines[j]);
                    if (lines[j].contains("*/")) {
                        multi += " "+lines[j].trim();
                        System.out.println("end");

                    } else {
                        System.out.println("not end");
                        multi += " "+lines[j].trim();
                    }
                }
                System.out.println("*********************************");
                System.out.println(multi);
                sInput.add(multi);
                i += counter;
                continue;
            }
            x = lines[i].split("(?<=\\(|\\[|\\{|=|\\+|-|/|\\*|!)|(?=\\)|\\]|\\}|=|\\+|-|/|\\*|!)|(?=\\;)|(?=\\,)|( |$)(?=(([^\"]*\"){2})*[^\"]*$)|(?=(([^\']*\'){2})*[^\']*$)( |$) ");
            for (int j = 0; j < x.length; j++) {
                //System.out.println(x[j]);
                sInput.add(x[j]);
            }

        }
        //sInput = input.split("(?<=\\(|\\+|\\*|-|=|/)|(?=\\)|\\*|\\+|-|=|/)|(?=\\;)|(?=\\,)|( |$)(?=(([^\"]*\"){2})*[^\"]*$)|(?=(([^\']*\'){2})*[^\']*$)( |$) ");

        for (int i = 0; i < sInput.size(); i++) {
            sInput.set(i, sInput.get(i).trim());
            System.out.println(sInput.get(i));
        }

        for (int i = 0; i < sInput.size(); i++) {
            try {
                //br = new BufferedReader(new FileReader(FILENAME));
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);

                //for (int k = 0; k < sInput.length; k++) {
                //    System.out.println(sInput[k]);
                //}
                String sCurrentLine;
                String record;
                String regex[];
                //System.out.println(sInput.get(i));
                while ((record = br.readLine()) != null) {
                    //System.out.println(record);
                    regex = record.split(" ");
                    //System.out.println(regex[0]);
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
