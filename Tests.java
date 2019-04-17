package comprehensive;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tests {
	
	List<String> sList = new ArrayList<String>();

	@Test
	void testFile() throws FileNotFoundException {
//		File f;
//		f = new File("./excuse.txt");
//		Scanner s = new Scanner(f);
//		CaptureGrammarDefinitions sut = new CaptureGrammarDefinitions();
//		sut.getArrayList("<plea>");
	}
	
	@Test
	void testMain()
	{
		String[] args = new String[2];
		args[0] = "./excuse.txt";
		args[1] = "1000";
		RandomPhraseGenerator.main(args);
	}
}