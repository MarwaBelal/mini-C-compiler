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

public class Compilers1 {

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    private static final String FILENAME = "C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\REs.txt";

    public static void main(String[] args) throws Exception {
        String data = readFileAsString("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\test.txt");
        ArrayList<Pair<String, String>> output = new ArrayList<Pair<String, String>>();
        BufferedReader br = null;
        FileReader fr = null;
        List<String> sInput = new ArrayList<String>();
        String x[];
        System.out.println("kl");
        System.out.println(data);
        String lines[] = data.split("\n|(?<=\\n)");
        int counter = 0;
        String multi = "";
        for (int i = 0; i < lines.length; i++) {
            System.out.println(i + lines[i]);
            if (lines[i].contains("//")) {
                sInput.add(lines[i]);
                continue;
            }
            if (lines[i].contains("/*")) {
                multi = lines[i];
                System.out.println("hnaa " + multi);
                int j;
                for (j = i + 1; j < lines.length; j++) {
                    if (lines[j].contains("*/")) {
                        multi += lines[j];
                        System.out.println("hnaaaaaaaaaaaaaaaaaaaaa " + multi);
                        break;
                    }
                    System.out.println("okayy");
                    System.out.println(j + " " + lines[j]);
                    multi = multi + lines[j];
                    System.out.println(multi);
                }

                sInput.add(multi);
                i += j;
            }

            x = lines[i].split("(?<=\\(|\\[|\\{|=|\\+|-|/|\\*|!)|(?=\\)|\\]|\\}|=|\\+|-|/|\\*|!)|(?=\\;)|(?=\\,)|( |$)(?=(([^\"]*\"){2})*[^\"]*$)|(?=(([^\']*\'){2})*[^\']*$)( |$) ");

            for (int j = 0; j < x.length; j++) {

                System.out.println(j + "    " + x[j]);
                sInput.add(x[j]);
            }

        }
        int c = 0;

        for (int i = 0; i < sInput.size(); i++) {
            sInput.set(i, sInput.get(i).trim());
            System.out.println("ppppppppppppppppp");
            System.out.println(sInput.get(i));
        }
        List<String> sInput2 = new ArrayList<String>();
        for (int y = 0; y < sInput.size(); y++) {
            if (sInput.get(y).isEmpty()) {
                continue;
            }
            System.out.println("yyyyyyyyyyyyyyyy " + y + "  " + sInput.get(y));
            sInput2.add(sInput.get(y));
        }

        for (int i = 0; i < sInput2.size(); i++) {
            try {
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
                String sCurrentLine;
                String record;
                String regex[];
                System.out.println(sInput2.get(i));
                while ((record = br.readLine()) != null) {
                    regex = record.split(" ");
                    Pattern pattern = Pattern.compile(regex[0]);
                    Matcher matcher = pattern.matcher(sInput2.get(i));

                    if (matcher.find()) {
                        output.add(new Pair<String, String>(sInput2.get(i), regex[1]));
                        break;
                    }
                    if (!matcher.find()) {
                        //System.out.println("kk");
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
        System.out.println("c" + c);
        System.out.println("moooooooooooooooooooooooooooooooooo");
        System.out.println(multi);
        PrintWriter out = new PrintWriter("C:\\Users\\Mariam\\Documents\\GitHub\\mini-C-compiler\\output.txt");
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i).getKey());
            System.out.print(" : ");
            System.out.println(output.get(i).getValue());
            out.println(output.get(i).getValue() + " : " + output.get(i).getKey());
        }
        System.out.println(output.size());
        System.out.println(sInput.size());
        out.close();
    }
}
