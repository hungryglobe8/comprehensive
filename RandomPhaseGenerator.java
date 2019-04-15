package comprehensive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
		
		FileReader f;
		try {
			f = new FileReader(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		//Should this be generic?
		CaptureGrammarDefinitions rulesList = new CaptureGrammarDefinitions(f);
		ArrayList<ArrayList<String>> myList = rulesList.getArrayList();
		myList.get(0).get(3);
	}

}
