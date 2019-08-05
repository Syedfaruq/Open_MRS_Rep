package Java_Practise;

import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates {

	public static void main(String[] args) {

		String Str = "Mississippi";

		System.out.println(remove_duplicates(Str));
	}

	public static String remove_duplicates(String Str)

	{
		Set<Character> set = new HashSet<Character>();
		StringBuffer sf = new StringBuffer();

		for (int i = 0; i < Str.length(); i++) {
			Character ch = Str.charAt(i);

			if (!set.contains(ch)) {
				set.add(ch);
				sf.append(ch);

			}
		}

		return sf.toString();

	}

}
