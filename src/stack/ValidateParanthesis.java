package stack;

import java.util.HashMap;
import java.util.Scanner;


public class ValidateParanthesis {
	
	public static void main(String[] args) throws StackOverflowException {
		Stack<Character> expressionStack = new Stack<Character>();
		//Put all valid Open and their closing braces in a Map as key and value
		HashMap<Character, Character> paranthesisSet = new HashMap<Character, Character>();
		paranthesisSet.put('{', '}');
		paranthesisSet.put('(', ')');
		paranthesisSet.put('[', ']');
		System.out.println("Enter an expression");
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		
		for(int i=0;i < expression.length();i++) {
			//Get each character and check if it is an open brace by checking if it is part of the map key's
			if(paranthesisSet.containsKey(expression.charAt(i))) {
				//If this is an open brace put it in the stack
				expressionStack.push(expression.charAt(i));
			} 
			//Check if it is a closing brace by seeing if it exists in map's values
			//if it is a closing brace then get the top value from stack and get its correct closing brace from map and compare
			//If they are a match then pop since it is a correct closing brace.
			//If it is not a match it is an invalid expression
			else if(paranthesisSet.containsValue(expression.charAt(i))) {
				try {
					if(paranthesisSet.get(expressionStack.peek()).equals(expression.charAt(i))) {
						expressionStack.pop();
					}
				} catch (StackUnderflowException e) {
					System.out.println("Invalid expression");
					e.printStackTrace();
					System.exit(0);
				}
			}
		}
		
		//If there are still opening braces left in the stack and the expression is completed traversing then it is an invalid expression as the closing brace is missing
		if(expressionStack.size() > 0)
			System.out.println("Invalid Expression");
		else
			System.out.println("Valid Expression");
		scan.close();
	}
}
