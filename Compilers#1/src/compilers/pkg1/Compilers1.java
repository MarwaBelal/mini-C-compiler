package compilers.pkg1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.io.*;
import javafx.util.Pair;

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
    private static final String REs = "C:\\Users\\LENOVO\\Documents\\GitHub\\mini-C-compiler\\REs.txt";

    public static void main(String[] args) throws Exception {
        //String data = readFileAsString("C:\\Users\\LENOVO\\Documents\\GitHub\\mini-C-compiler\\test.txt");
        String data = "(if) ( int) static 0 90 111 1nagham nagham3 _1 auto yes-yes 0.0 12 s, m; \"bla bla\" 'z' x1=x2 /x3 int intvalue = 10.0+5;  //this is a comment // this too ";
        //List<String> output = new ArrayList<String>();
        ArrayList <Pair <String,String> >output = 
                  new ArrayList <Pair <String,String> > ();
        BufferedReader br = null;
        FileReader fr = null;
        //String input = "(if) ( int) static 0 90 111 1nagham nagham3 _1 A != b = 4";
        String sInput[];
        //sInput = input.split(" |\\(|\\)");
        //sInput = input.split("(?=\\))|(?<=\\()| ");
        sInput = data.split("(?=\\))|(?<=\\()| ");
        for (int i = 0; i < sInput.length; i++) {
            System.out.println(sInput[i]);

        }
        String error = "error msg";
        String record;
        for (int i = 0; i < sInput.length; i++) {
            try {

                //br = new BufferedReader(new FileReader(FILENAME));
                fr = new FileReader(REs);
                br = new BufferedReader(fr);

                String sCurrentLine;
                String regex[];
                while ((record = br.readLine()) != null) {
                    //System.out.println(record);
                    regex = record.split(" ");
                    Pattern pattern = Pattern.compile(regex[0]);
                    Matcher matcher = pattern.matcher(sInput[i]);
                    //System.out.println(sInput[i]);
                    if (matcher.find()) {
                        //System.out.println("mariam");
                        output.add(new Pair <String,String> (sInput[i], regex[1]));
                        break;
                    } else {
                        //output.add(error);
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
        PrintWriter out = new PrintWriter("C:\\Users\\LENOVO\\Documents\\GitHub\\mini-C-compiler\\output.txt");
        for (int i = 0; i < output.size(); i++) {
            out.println(output.get(i) + " : ");
            System.out.println(output.get(i).getKey() + " : " + output.get(i).getValue());
        }
        out.close();
    }
}
