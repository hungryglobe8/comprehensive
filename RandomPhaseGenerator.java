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
public class RandomPhaseGenerator {

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
		
		//Should this be generic?
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
		int startIndex;
		int endIndex;
		String currWord;
		ArrayList<String> currList = rulesList.getArrayList("<start>");
		
		String addMe = getRandomElement(currList);
		s.append(addMe);
		if(addMe.contains("{"))
		{
		}
		
		return null;
	}
	
	private static String getRandomElement(ArrayList<String> sList)
	{
		return null;
		
	}
}
