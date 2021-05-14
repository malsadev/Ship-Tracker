import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * 
 */

public class ToolBox {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		File testFile = new File("testCSV.csv");
		Scanner testReader = new Scanner(testFile);
		int counter = 0;
		testReader.useDelimiter(",");
		ArrayList<String> testValues = new ArrayList<String>();
		while(testReader.hasNext()) {
			String token = testReader.next();
			if (counter == 4) {
				testReader.nextLine();
			}
			testValues.add(token);
			counter++;
		}
		
		
		
		for (String value: testValues) {
			System.out.println(value);
		}
		testReader.close();
		
		
	}
}
