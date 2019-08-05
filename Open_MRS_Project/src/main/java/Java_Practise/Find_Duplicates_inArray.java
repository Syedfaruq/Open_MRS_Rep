package Java_Practise;

import java.util.HashSet;
import java.util.Set;

public class Find_Duplicates_inArray {

	public static void main(String[] args) {
		String S[] = { "256 ", "256 ", "459", "459", "52", "49", "52", "52" };

		Set<String> store = new HashSet<String>();

		for (String name : S) {
			if (store.add(name) == false) {
				System.out.println("Duplicates are ::" + name);
			}

		}

	}
}
