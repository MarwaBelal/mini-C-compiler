package compilers.pkg1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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


public class Compilers1 {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    private static final String FILENAME = "C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\Compilers#1\\REs.txt";

    public static void main(String[] args) throws Exception {
        String input = readFileAsString("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\Compilers#1\\test.txt");
        ArrayList<Pair<String, String>> output = new ArrayList<Pair<String, String>>();
        BufferedReader br = null;
        FileReader fr = null;
        List<String> sInput = new ArrayList<String>();
        String x[];
        System.out.println(input);
        String lines[] = input.split("\n|(?<=\\n)");
        int counter = 0;
        String multi = "";
        String temp = "";
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() > 2 && lines[i].substring(lines[i].length() - 3, lines[i].length()).contains("\\n")) {
                lines[i] = lines[i].substring(0, lines[i].length() - 3);
            }
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
                for (int j = i + 1; j < lines.length; j++) {
                    counter++;
                    if (lines[j].equals("")) {
                        continue;
                    }
                    //System.out.println("line: " + lines[j]);
                    if (lines[j].contains("*/")) {
                        multi += " " + lines[j].trim();
                        //System.out.println("end");

                    } else {
                        //System.out.println("not end");
                        multi += " " + lines[j].trim();
                    }
                }
                sInput.add(multi);
                i += counter;
                continue;
            }
            x = lines[i].split("(?<=\\(|\\[|\\{|=|\\+|-|/|\\*|!)|(?=\\)|\\]|\\}|=|\\+|-|/|\\*|!)|(?=\\;)|(?=\\,)|( |$)(?=(([^\"]*\"){2})*[^\"]*$)|(?=(([^\']*\'){2})*[^\']*$)( |$) ");
            for (int j = 0; j < x.length; j++) {
                sInput.add(x[j]);
            }
        }
        for (int i = 0; i < sInput.size(); i++) {
            sInput.set(i, sInput.get(i).trim());
            //System.out.println(sInput.get(i));
        }
        List<String> sInput2 = new ArrayList<String>();
        for (int y = 0; y < sInput.size(); y++) {
            if (sInput.get(y).isEmpty()) {
                continue;
            }
            sInput2.add(sInput.get(y));
        }
        for (int i = 0; i < sInput2.size(); i++) {
            try {
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
                String sCurrentLine;
                String record;
                String regex[];
                Boolean flag = false;
                while ((record = br.readLine()) != null) {
                    regex = record.split(" ");
                    Pattern pattern = Pattern.compile(regex[0]);
                    Matcher matcher = pattern.matcher(sInput2.get(i));
                    if (matcher.find()) {
                        flag = true;
                        output.add(new Pair<String, String>(sInput2.get(i), regex[1]));
                        break;
                    }
                }
                if (flag == false) {
                    output.add(new Pair<String, String>(sInput2.get(i), "<error:didn't match>"));
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
        PrintWriter out = new PrintWriter("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\Compilers#1\\output.txt");
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i).getKey());
            System.out.print(" : ");
            System.out.println(output.get(i).getValue());
            out.println(output.get(i).getValue() + " : " + output.get(i).getKey());
        }
        //System.out.println(output.size());
        //System.out.println(sInput2.size());
        out.close();

    }
}
