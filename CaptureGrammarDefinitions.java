package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CaptureGrammarDefinitions {

	private HashMap<String, ArrayList<String>> myMap;
	private Scanner s;
	
	public CaptureGrammarDefinitions(File f, Scanner _s)
	{
		myMap = new LinkedHashMap<String, ArrayList<String>>();
		s = _s;
		
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
			if(s.nextLine().equals("{"))
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
		
		//Skip space between non-terminal and phrases that can follow it.
		s.nextLine();
		String token = s.nextLine();
		//Should we keep track of non-terminals within the line?
		while (!token.equals("}"))
		{
			sList.add(token);
			token = s.nextLine();
		}
		
		myMap.put(key, sList);
		return;
	}
	
	//StringBuilder StringBuffer for random generation of strings.
}
