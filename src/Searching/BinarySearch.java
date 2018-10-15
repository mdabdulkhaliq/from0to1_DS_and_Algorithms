package Searching;

public class BinarySearch {

	public static int binarySearch(int[] elements, int searchItem) {
		int minIndex = 0;
		int maxIndex = elements.length -1;
		
		while(minIndex <= maxIndex) {
			int midIndex = (minIndex+maxIndex) / 2;
			if(searchItem == elements[midIndex]) {
				return midIndex;
			} else if(searchItem < elements[midIndex]) {
				maxIndex = midIndex -1;
			} else if(searchItem > elements[midIndex]) {
				minIndex = midIndex +1;
			}
		}
		
		//Not found
		return -1;
		
	}
}
