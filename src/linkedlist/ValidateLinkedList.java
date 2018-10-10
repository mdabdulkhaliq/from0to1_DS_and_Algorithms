package linkedlist;

import java.util.Scanner;

public class ValidateLinkedList {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		printOptions();
		int value = getValue("Select an option");

		while(value > 0 && value < 14 ) {
			switch(value) {
			case 1: 
				linkedList.addLast(getValue("Enter a node value to add - Default last"));
				linkedList.print();
				break;
			case 2: 
				linkedList.addFirst(getValue("Enter a node value to add at the beginning"));
				linkedList.print();
				break;
			case 3: 
				linkedList.addLast(getValue("Enter a node value to add at the last"));
				linkedList.print();
				break;
			case 4: 
				linkedList.addAtIndex(getValue("Enter index"),getValue("Enter a node value"));
				linkedList.print();
				break;
			case 5: 
				linkedList.deleteFirst();
				linkedList.print();
				break;
			case 6: 
				linkedList.deleteLast();
				linkedList.print();
				break;
			case 7: 
				linkedList.delete(getValue("Enter a node value to be deleted"));
				linkedList.print();
				break;
			case 8: 
				System.out.println(linkedList.getFirst());
				break;
			case 9: 
				System.out.println(linkedList.getLast());
				break;
			case 10: 
				System.out.println(linkedList.indexOf(getValue("Enter a node value to find its index")));
				break;
			case 11: 
				System.out.println(linkedList.lastIndexOf(getValue("Enter a node value to find its last index")));
				break;
			case 12: 
				System.out.println(linkedList.contains(getValue("Enter a node value to check if it exists")));
				break;
			case 13: 
				System.out.println(linkedList.size());
				linkedList.print();
				break;
			case 0:
				System.out.println("Exiting");
				scan.close();
				break;
			}
			//printOptions();
			value = getValue("Select an option");
		}	
	}

	private static void printOptions() {
		System.out.println("***************************************");
		System.out.println("1.Add an element - default at last");
		System.out.println("2.Add an element at the beginning");
		System.out.println("3.Add an element at the last");
		System.out.println("4.Add an element at a specific index");
		System.out.println("5.Delete the first element");
		System.out.println("6.Delete the last element");
		System.out.println("7.Delete an element");
		System.out.println("8.Get the first element");
		System.out.println("9.Get the last element");
		System.out.println("10.Index of the element");
		System.out.println("11.Last index of the element");
		System.out.println("12.Contains the element");
		System.out.println("13.Size of the LinkedList");
		System.out.println("0. Exit");
		System.out.println("***************************************");

	}

	private static int getValue(String message) {
		System.out.print(message);
		int num = scan.nextInt();
		return num;
	}

}
