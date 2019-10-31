import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		HashTableLinearProbe<String, String> hashTable = new HashTableLinearProbe<String, String>();
		Scanner input = new Scanner(System.in);
		String userInput = "";
		String key, value;
		while (true) {
			System.out.println(" 1: insert"
					+ "\n 2: delete"
					+ "\n 3: find"
					+ "\n 4: test hashing"
					+ "\n 5: end"
					+ "\nWhat do you want to run?");
			userInput = input.nextLine();
			if (userInput.equals("insert") || userInput.equals("1")) {
				System.out.println("input key");
				userInput = input.nextLine();
				key = userInput;
				
				System.out.println("input value");
				userInput = input.nextLine();
				value = userInput;
				hashTable.insert(key, value);
			}
			else if(userInput.equals("delete") || userInput.equals("2")) {
				System.out.println("input key");
				userInput = input.nextLine();
				key = userInput;
				hashTable.delete(key);
			}
			else if (userInput.equals("find") || userInput.equals("3")) {
				
			}
			else if (userInput.equals("test hashing") || userInput.equals("4")) {
				
			}
			else if (userInput.equals("end") || userInput.contentEquals("5")) {
				break;
			}
		}
		
		
		/*Scanner in;
		if (args.length != 2) {
			System.out.print("Error Incorrect Arguments:" + Arrays.toString(args));
			System.exit(0);
		}
		try {
			File input_file = new File (args[0]);
			in = new Scanner(input_file);
			File output_file = new File (args[1]);
			PrintWriter out;
			out = new PrintWriter(output_file);
			
			HashTableLinearProbe hashTable = new HashTableLinearProbe();
			
			String operation = "";
			String stringKey;
			int intKey, value;
			boolean result;
			
			while(in.hasNext()) {
				operation = in.next();
				
				switch (operation) {
				case "Insert" :
					try {
						//Need to figure out how to convert int and string
					}
					catch (Exception e) {
						
					}
				}
			}
			
			in.close();
			out.close();
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		*/
	}
	
}
