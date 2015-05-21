package randomproblems;

import java.util.Scanner;

public class PalindomeIndex {

	public static final boolean TEST = false;

	public static String removeIndex(String s) {

		char[] c = s.toCharArray();
		int len = c.length;
		int n = len / 2;

		for (int i = 0; i < n; i++) {
			if (c[i] != c[len - i - 1]) {
				int left = i;
				int right = len - i - 1;
				StringBuilder sb = new StringBuilder(s);
				sb.deleteCharAt(left);
				return isPalindrome(sb.toString()) ? String.valueOf(left) : String
						.valueOf(right);
			}
		}
		return "-1";
	}

	public static boolean isPalindrome(String s) {
		char[] c = s.toCharArray();
		int len = c.length;
		for (int i = 0; i < len / 2; i++) {
			if (c[i] != c[len - 1 - i])
				return false;
		}
		return true;
	}

	public static void run(Scanner in) {
		int queries = Integer.valueOf(in.nextLine());
		for (int i = 0; i < queries; i++) {
			String s = in.nextLine();
			System.out.println(removeIndex(s));
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
