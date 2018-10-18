package stringprograms;

import java.util.HashMap;
import java.util.Scanner;

public class CheckIf2StringAreAnagrams {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter first string:");
		String firstString = scan.next();
		System.out.println("Enter second string:");
		String secondString = scan.next();
		
		if(firstString.length() != secondString.length()) {
			System.out.println("cannot be anagrams, not of equal size");
			System.exit(1);
		}
		
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0;i<firstString.length();i++) {
			char currentCharacter = firstString.charAt(i);
			if(hm.containsKey((Character)currentCharacter)) {
				hm.put(currentCharacter, hm.get(currentCharacter).intValue() + 1);
			}else {
				hm.put(currentCharacter, 1);
			}
		}
		
		for(int i=0;i<secondString.length();i++) {
			char currentCharacter = secondString.charAt(i);
			if(hm.containsKey(currentCharacter)) {
				int newValue = hm.get(currentCharacter).intValue() - 1;
				if(newValue < 0) {
					System.out.println("Not anagrams the second string has more characters of a specific letter");
					System.exit(1);
				}else {
					hm.put(currentCharacter, newValue);
				}
			}else {
				System.out.println("Not anagrams");
				System.exit(1);
			}
		}
		
		System.out.println("They are anagrams");
		scan.close();
	}
}
