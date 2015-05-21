package hackerrank;

import java.util.Scanner;

public class TwoStrings {

	public static final boolean TEST = false;

	public static boolean hasSubstring(String a, String b) {
		boolean[] c = new boolean[26];
		char[] car = a.toCharArray();
		for (int i = 0; i < car.length; i++)
			c[car[i] - 'a'] = true;
		car = b.toCharArray();
		for (int i = 0; i < car.length; i++) {
			if (c[car[i] - 'a'] == true)
				return true;
		}
		return false;
	}

	public static void run(Scanner in) {
		int queries = Integer.valueOf(in.nextLine());
		for (int i = 0; i < queries; i++) {
			String a = in.nextLine();
			String b = in.nextLine();
			if (hasSubstring(a, b))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {

		}
	}
}
