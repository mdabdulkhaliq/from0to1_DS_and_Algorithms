package stack;

import java.util.Scanner;

public class ValidateStack {

	static Scanner scan = new Scanner(System.in);
	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> minimumElementStack = new Stack<Integer>();
	
	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		printOptions();
		int option = getValue("Enter an option");
		while(true) {
			switch(option) {
			case 1: 
				int element = getValue("Enter data to push");
				stack.push(element);
				if(minimumElementStack.isEmpty()) {
					minimumElementStack.push(element);
				}else {
					if(minimumElementStack.peek() > element) {
						minimumElementStack.push(element);
					} else {
						minimumElementStack.push(minimumElementStack.peek());
					}
				}
				stack.print();
				break;
			case 2: 
				stack.pop();
				minimumElementStack.pop();
				stack.print();
				break;
			case 3: 
				System.out.println(stack.peek());
				break;
			case 4: 
				System.out.println(stack.isEmpty());
				break;
			case 5: 
				System.out.println(stack.isFull());
				break;
			case 6: 
				System.out.println(stack.size());
				break;
			case 7: 
				System.out.println(minimumElementStack.peek());
				break;
			case 0:
				System.exit(0);
			default: 
				break;
			}
			option = getValue("Enter an option");
		}
	}

	private static int getValue(String message) {
		System.out.print(message);
		int num = scan.nextInt();
		return num;
	}

	private static void printOptions() {
		System.out.println("1. Push Node");
		System.out.println("2. Pop Node");
		System.out.println("3. Peek Node");
		System.out.println("4. Is the stack Empty?");
		System.out.println("5. Is the stack Full?");
		System.out.println("6. Print size of the stack");
		System.out.println("7. Find Minimum Element");
	}

}
