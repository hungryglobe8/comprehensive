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
		//OutputStrem
//		OutputStream out = new BufferedOutputStream(System.out);
//		for(int i = 0; i < num; i++)
//		{
//			try {
//				out.write((generatePhrase() + "\n").getBytes());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		//System.out
//		for(int i = 0; i < num; i++)
//		{
//			System.out.print(generatePhrase() + "\n");
//		}
		
		//BufferedWriter - I think this is fastest
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < num; i++)
		{
			try {
				log.write(generatePhrase() + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method uses the captured grammar definitions to generate num random phrases.
	 * @param num
	 * @return
	 */
	private static StringBuilder generatePhrase()
	{
		s = new StringBuilder(rulesList.randomLine("<start>"));	
		generateWords(s);

		return s;
	}

	
	private static void generateWords(StringBuilder currLine)
	{
		int i = 0;
		while(i < currLine.length())
		{
			if (currLine.charAt(i) == '<')
			{
				int closeBrace = currLine.indexOf(">", i);
				String key = currLine.substring(i, closeBrace + 1);
				String newLine = rulesList.randomLine(key);
				
				currLine.delete(i, closeBrace + 1);
				currLine.insert(i, newLine);
				i--;
			}
			
			i++;
		}
//		//base case, no more "<"
//		int openBrace = currLine.indexOf("<"); 
//
//		if(openBrace == -1)
//		{
//			s.append(currLine); 
//			return; 
//		}
//		
//		int closeBrace = currLine.indexOf(">"); 
//		
//		String beginning = currLine.substring(0, openBrace); 
//		String key = currLine.substring(openBrace, closeBrace + 1); 
//		String following = currLine.substring(closeBrace + 1, currLine.length()); 
//		String replacement = rulesList.randomLine(key);
//		
////		currLine = beginning.concat(replacement).concat(following);
////		generateWords(currLine);
//		generateWords(beginning);
//		generateWords(replacement); 
//		generateWords(following); 	
	}
}
