package stringprograms;

import java.util.Scanner;

public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		System.out.println("Enter a string:");
		Scanner scan = new Scanner(System.in);
		String someString = scan.nextLine();
		for(int i=0;i<someString.length();i++) {
			char currentCharacter = someString.charAt(i);
			System.out.println("Current character is:" + currentCharacter);
			if(someString.indexOf(currentCharacter) == someString.lastIndexOf(currentCharacter)) {
				System.out.println("Non-repeating charcter is:" + currentCharacter);
			}

		}
		scan.close();
	}
}
