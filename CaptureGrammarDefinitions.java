package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class CaptureGrammarDefinitions {

	private HashMap<String, ArrayList<String>> myMap;
	private BufferedReader reader; 
	private Random rng;

	public CaptureGrammarDefinitions(BufferedReader _reader) throws IOException
	{
		reader = _reader;
		myMap = new LinkedHashMap<String, ArrayList<String>>();
		rng = new Random();
		
		while(true)
		{
			//If a non-terminal is found, then the strings following it will be added.
			if(findNextNonTerminal())
			{
				//Keys and the value associated with them are added to myMap in this method.
				addImportantStrings();
			}
			//Nothing else found in file.
			else
				break;
		}
		reader.close();
	}
	
	/**
	 * Returns the ArrayList associated with a specific key.
	 */
	public ArrayList<String> getArrayList(String key)
	{
		return myMap.get(key);
	}
	
	/**
	 * Returns a random line from the ArrayList associated with a specific key.
	 */
	public String randomLine(String key)
	{
		ArrayList<String> sList = myMap.get(key);
		return sList.get(rng.nextInt(sList.size()));
	}
	
	/**
	 * This method ignores lines between non-terminal definitions and captures the next non-terminal found.
	 * @param newLine 
	 * @return 
	 * @throws IOException 
	 * 
	 */
	private boolean findNextNonTerminal() throws IOException
	{
		String newLine;
		while((newLine = reader.readLine()) != null)
		{
			if(newLine.equals("{"))
			{
				return true; 
			}
		}
		return false;
	}
	
	private void addImportantStrings() throws IOException
	{
		ArrayList<String> sList = new ArrayList<String>();
		
		//Save the non-terminal that will be used as a key in the HashMap.
		String key = reader.readLine();
	
		String token;
		//Should we keep track of non-terminals within the line?
		while (!(token = reader.readLine()).equals("}"))
		{
			sList.add(token);
		}
		
		myMap.put(key, sList);
		return;
	}
}
