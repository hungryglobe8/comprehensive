package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Casey Rand and Morgan Mischo
 */
public class RandomPhraseGenerator {
	

	/**
	 * First argument should include fileName containing grammar rules.
	 * Second argument is the number of random phrases to generate.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IllegalArgumentException {
		if (args.length != 2)
		{
			throw new IllegalArgumentException("Args should include a file name followed by an integer.");
		}
		
		File f;
		Scanner s;
		try {
			s = new Scanner(f = new File(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		CaptureGrammarDefinitions rulesList = new CaptureGrammarDefinitions(f, s);
		
		Integer num = Integer.parseInt(args[1]);
		//Generate phrases
		for(int i = 0; i < num; i++)
		{
			System.out.println(generatePhrase(rulesList));
		}
		return;
	}
	
	/**
	 * This method uses the captured grammar definitions to generate num random phrases.
	 * @param num
	 * @return
	 */
	private static String generatePhrase(CaptureGrammarDefinitions rulesList)
	{
		StringBuilder s = new StringBuilder();
		String startLine = rulesList.randomLine("<start>");
		
		s.append(startLine);
		generateWords(s, startLine, rulesList);
		
		return s.toString();
	}
	
	private static void generateWords(StringBuilder s, String currLine, CaptureGrammarDefinitions rulesList)
	{
		if (!s.toString().contains("<"))
		{
			return;
		}
		
		else
		{
			int startIndex = s.indexOf("<");
			int endIndex = s.indexOf(">", startIndex);
			String key = s.substring(startIndex, endIndex + 1);
			
			String newLine = rulesList.randomLine(key);
			
			if(newLine.contains("<"))
			{
				//run on here 
			}
			
			s.replace(startIndex, endIndex + 1, newLine);
			generateWords(s, newLine, rulesList);
		}
	}
}
