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

    private static final String FILENAME = "C:\\Users\\Belal\\Desktop\\mini-C-compiler-master\\phase 1\\REs.txt";

    public static void main(String[] args) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("C:\\Users\\Belal\\Desktop\\mini-C-compiler-master\\phase 1\\dicussion.txt")));
        List<token> tokens = new ArrayList<token>();
        String record;
        String regex[];
        Scanner s = new Scanner(new File(FILENAME));
        while (s.hasNextLine()) {
            record = s.nextLine();
            regex = record.split(" ");
            Pattern pattern = Pattern.compile(regex[0]);
            Matcher matcher = pattern.matcher(data);
            int x = 0;
            while (matcher.find()) {
                x++;
                int start = matcher.start();
                int end = matcher.end();
                String o = "";
                if (data.length() > end) {
                    o = data.substring(start, end);
                } else {
                    o = data.substring(start, data.length());
                }
                String k = "";
                k = data.substring(0, start);
                for (int a = 0; a < o.length(); a++) {
                    k = k + " ";
                }
                k = k + data.substring(end, data.length());
                data = k;
                token t = new token();
                t.str = o.trim();
                t.token = regex[1];
                t.strt = start;
                tokens.add(t);
            }
        }
        Collections.sort(tokens, new Comparator<token>() {

            @Override
            public int compare(token o1, token o2) {
                return o1.strt - o2.strt;
            }
        });

        PrintWriter out = new PrintWriter("C:\\Users\\Belal\\Desktop\\mini-C-compiler-master\\phase 1\\outputt.txt");
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).str);
            System.out.print(" : ");
            System.out.println(tokens.get(i).token);
            out.println(tokens.get(i).str + " : " + tokens.get(i).token);
        }

        String error[];
        error = data.split(" ");
        for (int i = 0; i < error.length; i++) {
            if (!error[i].trim().equals("")) {
                System.out.println(error[i].trim() + ": <error:couldn't match>");
            }
            out.println(error[i].trim() + ": <error:couldn't match>");
        }
        out.close();
        
        //Syntax Analyzer 
        List<token> reads = new ArrayList<token>();
        token t = new token();
        String readTokens = new String(Files.readAllBytes(Paths.get("C:\\Users\\Belal\\Desktop\\mini-C-compiler-master\\phase 1\\outputt.txt")));
        for (int i = 0; i < tokens.size(); i++) {
        //  t.str = tokens.get(i).str;
            t.token = tokens.get(i).token;
            reads.add(t);
        }
        
        
    }
}
