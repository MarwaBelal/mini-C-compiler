package compilers.pkg1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Nagham
 */
public class Compilers1 {
    public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
    private static final String FILENAME = "C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\REs.txt";
    
    public static void main(String[] args) throws Exception {
        String data = readFileAsString("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\test.txt"); 
        List<String> output = new ArrayList<String>();
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
        for (int i = 0; i < sInput.length; i++) {
            try {

                //br = new BufferedReader(new FileReader(FILENAME));
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);

                String sCurrentLine;
                String record;
                String regex[];
                while ((record = br.readLine()) != null) {
                    //System.out.println(record);
                    regex = record.split(" ");
                    Pattern pattern = Pattern.compile(regex[0]);
                    Matcher matcher = pattern.matcher(sInput[i]);
                    //System.out.println(sInput[i]);
                    if (matcher.find()) {
                        output.add(regex[1]);
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
            System.out.println(output.get(i));
        }
    }
}