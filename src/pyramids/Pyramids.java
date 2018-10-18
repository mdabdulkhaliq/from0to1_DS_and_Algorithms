package pyramids;

import java.util.Scanner;

public class Pyramids {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of rows to print:");
		int rows = scan.nextInt();

		
/*		
 		*
		**
		***
		**** 
*/
		//Half pyramid using *
		for(int i=1; i<=rows;i++) {
			for(int j=1 ; j <= i ; j ++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		/*
		1
		12
		123
		1234
		 */
		//Half pyramid using numbers
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println("");
		}

		/*
		A
		BB
		CCC
		DDDD
		 */
		char[] alphabets = {'A','B','C','D','E','F','G'};
		for(int i=0;i<rows;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(alphabets[i]);
			}
			System.out.println("");
		}

		/*
		****
		***
		**
		*
		 */
		//inverted half pyramid using *
		for(int i=rows;i>0;i--) {
			for(int j =1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		1234
		123
		12
		1
		 */
		//inverted half pyramid using numbers
		for(int i=rows;i>0;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println("");
		}

		/*
		   *
		  ***
		 *****
		*******
		 */
		//Full pyramid using stars
		for(int i=1;i<=rows;i++) {
			for(int spaces=1;spaces<=rows-i;spaces++) {
				System.out.print(" ");
			}
			int stars = 0;
			while(stars != (2*i - 1)) {
				System.out.print("*");
				stars++;
			}
			System.out.println("");
		}

		/*
		*******
		 *****
		  ***
		   *
		 */
		//Inverted pyramid using stars
		for(int i=rows;i>=1;i--) {
			for(int spaces=1;spaces<=rows-i;spaces++) {
				System.out.print(" ");
			}
			int stars = 0;
			while(stars != (2*i - 1)) {
				System.out.print("*");
				stars++;
			}
			System.out.println("");
		}

		//Floyds triangle
		/*
		1
		23
		456
		78910
		 */
		int number=0;
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(++number);
			}
			System.out.println("");
		}
		
		/*
		      *
		     **
		    ***
		   ****
		  *****
		  OR
		        * 
			   * * 
			  * * * 
			 * * * * 
			* * * * * 
		 */
		for(int i=1;i<=rows;i++) {
			for(int spaces=1;spaces<=rows-i;spaces++) {
				System.out.print(" ");
			}
			
			for(int j=1;j<=i;j++) {
				System.out.print("*");
				//System.out.print("* ");// This will give second output just a difference of space
			}
			System.out.println("");
		}
		
		scan.close();
	}

}
