package stringprograms;

import java.util.HashSet;
import java.util.Scanner;

public class PrintDuplicateCharacters {
	
/*	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string:");
		String someString = scan.nextLine();
		char[] stringChars = someString.toCharArray();
		for(int i=0;i<stringChars.length-1;i++) {
			for(int j=i+1;j<stringChars.length;j++) {
				if(stringChars[i] == stringChars[j]) {
					System.out.println("Found a duplicate for:" + stringChars[i]);
				}
			}
		}
		scan.close();
	}*/

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string:");
		String someString = scan.next();
		HashSet<Character> chars = new HashSet<>();
		for(int i=0;i<someString.length();i++) {
			someString.charAt(i);
			if(!chars.add(someString.charAt(i))) {
				System.out.println("Duplicate character:" + someString.charAt(i));
			}
		}
		scan.close();
	}

	//If we need a count, then save the character in a map with value of count instead of using a set
	
}
