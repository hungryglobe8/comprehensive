package comprehensive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 
 * 
 * @author Casey Rand and Morgan Mischo
 */
public class RandomPhraseGenerator {
	
	public static StringBuilder s;
	public static CaptureGrammarDefinitions rulesList;

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

		String fileName = args[0];
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			rulesList = new CaptureGrammarDefinitions(in);
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
		
		
		Integer num = Integer.parseInt(args[1]);

		for(int i = 0; i < num; i++)
		{
			System.out.print(generatePhrase() + "\n");
		}
		//BufferedWriter - I think this is fastest
//		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
//		for(int i = 0; i < num; i++)
//		{
//			try {
//				log.write(generatePhrase() + "\n");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * This method uses the captured grammar definitions to generate num random phrases.
	 * @param num
	 * @return
	 */
	private static String generatePhrase()
	{
		s = new StringBuilder();	
		generateWords(rulesList.randomLine("<start>"));
		return s.toString();
	}

	
	private static void generateWords(String currLine)
	{
		int i = 0;
		while(i < currLine.length())
		{
			char newChar = currLine.charAt(i);
			if (newChar == '<')
			{
				int closeBrace = currLine.indexOf(">", i);
				String key = currLine.substring(i, closeBrace + 1);
				String newLine = rulesList.randomLine(key);
				
				generateWords(newLine);
				
				i += key.length() - 1;
			}
			else 
			{
				s.append(newChar);
			}
			i++;
		}	
		return;
	}
}
