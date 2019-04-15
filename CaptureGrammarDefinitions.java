package comprehensive;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CaptureGrammarDefinitions {

	private HashMap<String, ArrayList<String>> myMap;
	private Scanner s;
	
	public CaptureGrammarDefinitions(FileReader f)
	{
		myMap = new LinkedHashMap<String, ArrayList<String>>();
		s = new Scanner(f);
		
		while(s.hasNext())
		{
			String key = findNextNonTerminal();
			addImportantStrings(key);
		}
		s.close();
	}
	
	/**
	 * Returns the ArrayList associated with a specific key.
	 */
	public ArrayList<String> getArrayList(String key)
	{
		return myMap.get(key);
	}
	
	/**
	 * This method ignores lines between non-terminal definitions and captures the next non-terminal found.
	 * @return 
	 * 
	 */
	private String findNextNonTerminal()
	{
		while(s.hasNextLine())
		{
			if(s.nextLine().contains("{"))
			{
				return s.next();
			}
		}
		
		return null;
		}
	
	private void addImportantStrings(String key)
	{
		if(key == null)
		{
			return;
		}
		ArrayList<String> sList = new ArrayList<String>();
		
		while (!s.nextLine().contains("}"))
		{
			sList.add(s.next());
		}
		
		myMap.put(key, sList);
		return;
	}
}
