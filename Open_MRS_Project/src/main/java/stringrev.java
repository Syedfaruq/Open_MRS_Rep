import java.util.Scanner;

public class stringrev {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any String::");

		String Str = sc.nextLine();
		char c[] = Str.toCharArray();

		for (int i = c.length - 1; i >= 0; i--) {

			System.out.print(c[i]);
		}

	}

}
