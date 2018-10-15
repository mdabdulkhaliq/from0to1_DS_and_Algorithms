package sorting;

import java.util.Scanner;

public class SortingAlgorithms {
	//Declare an array
	static int[] elements = new int[5];

	public static void main(String[] args) {	
		//Initialize the array with data
		Scanner scan = new Scanner(System.in);
		for(int i=0; i < elements.length ;i++) {
			System.out.println("Enter an element");
			elements[i] = scan.nextInt();
		}		

		System.out.println("Select sorting method");
		int option = scan.nextInt();
		switch(option) {
		case 1:
			selectionSort();
			System.out.println("Sorted list using Selection sort is:");
			printElements();
			break;
		case 2:
			bubbleSort();
			System.out.println("Sorted list using Bubble sort is:");
			printElements();
			break;
		case 3:
			insertionSort();
			System.out.println("Sorted list using Insertion sort is:");
			printElements();
			break;
		case 4:
			shellSort();
			System.out.println("Sorted list using Shell sort is:");
			printElements();
			break;
		case 5:
			mergeSort(elements);
			System.out.println("Sorted list using Shell sort is:");
			printElements();
			break;
		default:
			break;
		}
		scan.close();
	}
	
	public static void printElements() {
		for(int i=0;i<elements.length;i++) {
			System.out.print(elements[i] + "-");
		}
	}

	public static void swap(int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

	private static void selectionSort() {
		for(int i=0; i < elements.length -1 ; i++) {
			for(int j=i+1;j<elements.length;j++) {
				if(elements[i] > elements[j])
					swap(i,j);
			}
		}
	}

	private static void bubbleSort() {
		for(int i=0;i<elements.length;i++) {
			//For adaptiveness
			boolean didSwap = false;
			for(int j=0;j<elements.length-i-1;j++) {
				if(elements[j] > elements[j+1]) {
					swap(j, j+1);
					didSwap = true;
				}
			}
			//If no swap in this iteration then the list is already sorted
			if(!didSwap) {
				System.out.println("Already sorted");
				break;
			}
		}
	}
	
	public static void insertionSort() {
		for(int i=0;i<elements.length-1;i++) {
			for(int j=i+1;j>0;j--) {
				if(elements[j] < elements[j-1]) {
					swap(j, j-1);
				}else {
					break; //Element is in right position no need to check further.
				}
			}
		}
	}
	
	public static void modified_InsertionSort_ForShellSort(int startIndex, int increment) {
		for(int i=startIndex; i<elements.length; i=i+increment) {
			for(int j= Math.min(i+increment, elements.length-1);
					j-increment>=0;
					j=j-increment) {
				if(elements[j] < elements[j-increment]) {
					swap(j, j-increment);
				}else {
					break; //Element is in right position no need to check further.
				}
			}
		}
	}
	
	public static void shellSort() {
		int increment = elements.length/2; //can be any number
		while(increment >= 1) {
			for(int startIndex=0; startIndex < increment; startIndex++) {
				modified_InsertionSort_ForShellSort(startIndex, increment);
			}
			increment = increment/2;
		}
	}
	
	private static void mergeSort(int[] elements) {
		if(elements.length == 1)
			return;
		
		int midIndex = elements.length/2;
		int[] firstHalf = new int[midIndex];
		int[] secondHalf = new int[elements.length - midIndex];
		
		//Split original array into two
		split(elements, firstHalf, secondHalf);
		
		//Go on splitting the divided array until it is 1 element and it gets returned back
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		
		//Merge the elements in sorted order
		merge(elements, firstHalf, secondHalf);
		
	}
	
	//Split an array into two arrays of equal halfs
	private static void split(int[] elements, int[] firstHalf, int[] secondHalf) {
		for(int i=0;i<elements.length/2;i++) {
			firstHalf[i] = elements[i];
		}
		for(int i=elements.length/2,j=0;i<elements.length;i++,j++) {
			secondHalf[j] = elements[i];
		}
	}
	
	//Merge two arrays into one array in a sorted order
	private static void merge(int[] elements, int[] firstHalf, int[] secondHalf) {
		int elementsIndex=0;
		int firstHalfIndex=0;
		int secondHalfIndex=0;
		
		while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
			if(firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
				elements[elementsIndex] = firstHalf[firstHalfIndex];
				firstHalfIndex++;
			}else {
				elements[elementsIndex] = secondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			elementsIndex++;
		}
		
		while(firstHalfIndex < firstHalf.length) {
			elements[elementsIndex] = firstHalf[firstHalfIndex];
			firstHalfIndex++;
			elementsIndex++;
		}
		
		while(secondHalfIndex < secondHalf.length) {
			elements[elementsIndex] = secondHalf[secondHalfIndex];
			secondHalfIndex++;
			elementsIndex++;
		}
		
	}
	
	public static int partitionQuickSort(int[] elements, int startIndex, int endIndex) {
		//Make the last element as the pivot element
		int pivot = elements[endIndex];
		//Make the first element as the pivot index
		int pIndex = startIndex;
		//Loop from starting element to one less then the pivot which is the last index
		for(int i=startIndex; i<endIndex; i++) {
			if(elements[i] <= pivot) {
				swap(i, pIndex);
				pIndex++;
			}
		}
		swap(pIndex, endIndex);
		return pIndex;
	}
	
	public static void quickSort(int[] elements, int startIndex, int endIndex) {
		if(startIndex >= endIndex)
			return;
		
		int pivotIndex = partitionQuickSort(elements, startIndex, endIndex);
		quickSort(elements, startIndex, pivotIndex - 1);
		quickSort(elements, pivotIndex + 1, endIndex);
		
	}

}
