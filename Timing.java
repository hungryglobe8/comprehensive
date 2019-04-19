package comprehensive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Timing {
	
	final static int TIMES_TO_LOOP = 1000;
	final static int problemSize = 100000;
	
	public static<E> void main (String[] args) {
//		fileRead();
		createNewLine();
	}

	private static void fileRead() {
		
		for(int i = 0; i < 10; i++)
		{
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader("./excuse.txt"));
				CaptureGrammarDefinitions rulesList = new CaptureGrammarDefinitions(in);
			} catch (FileNotFoundException e) {
				return;
			} catch (IOException e) {
				return;
			}
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		System.out.println(averageTime);
		}
	}
	
	private static void createNewLine() {
		
		BufferedReader in;
		CaptureGrammarDefinitions rulesList;
		try {
			in = new BufferedReader(new FileReader("./excuse.txt"));
			rulesList = new CaptureGrammarDefinitions(in);
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
		
		for(int i = 0; i < 10; i++)
		{
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			rulesList.randomLine("<start>");
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		System.out.println(averageTime);
		}
	}
}