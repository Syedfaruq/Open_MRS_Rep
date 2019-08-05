package Java_Practise;

import java.util.Scanner;

public class Word_Count {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter any String::");
		String S = sc.nextLine();
		int Count = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != ' ') {
				Count++;
			}

		}

		System.out.println("The length of the String is::" + Count);

	}

}
