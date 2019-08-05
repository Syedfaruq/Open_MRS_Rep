package Java_Practise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class rem_dup {

	public static void main(String[] args) {

		Scanner SC = new Scanner(System.in);
		System.out.println("Enter a String::");

		String Str = SC.next();

		Set<Character> set = new HashSet<Character>();

		StringBuffer sf = new StringBuffer();

		System.out.println("Original String is::" + Str);
		for (int i = 0; i < Str.length(); i++) {

			Character ch = Str.charAt(i);

			if (!set.contains(ch)) {
				set.add(ch);
				sf.append(ch);

			}

		}
		System.out.println("String after removal of duplicates::" + sf);

	}

}
