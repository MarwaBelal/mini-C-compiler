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

/**
 *
 * @author Nagham
 */
public class Compilers1 {

    private static final String FILENAME = "C:\\Users\\LENOVO\\Desktop\\REs.txt";

	public static void main(String[] args) {
            List<String> output = new ArrayList<String>();
            BufferedReader br = null;
            FileReader fr = null;
            String input = "if int static 0 90 111 1nagham nagham3 _1 auto true false EOF for do";
            String sInput[];
            sInput = input.split(" |\\(|\\)");
            
            for (int i=0; i<sInput.length ; i++){
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
                                //System.out.println(matcher);
                                if (matcher.find())
                                {
                                    output.add(regex[1]);
                                    break;
                                }
                                
                                
                                
                                
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				//ex.printStackTrace();

			}

		}
	}
            for (int i=0; i<output.size() ; i++){
                System.out.println(output.get(i));
            }
        }

   

}
