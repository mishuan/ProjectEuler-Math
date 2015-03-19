package randomproblems;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {

	public static final boolean TEST = false;

	public static String nextString(String s) {
		char[] c = s.toCharArray();
		for (int i = c.length - 2; i >= 0; i--) {
			if (c[i] < c[i + 1]) {
				int idx = findFirstSmaller(c, i);
				char temp = c[i];
				c[i] = c[idx];
				c[idx] = temp;
				s = new String(c);
				String s1 = s.substring(0, i + 1);
				char[] s2 = s.substring(i + 1, s.length()).toCharArray();
				Arrays.sort(s2);
				return s1 + String.valueOf(s2);
			}
		}
		return "no answer";
	}

	public static int findFirstSmaller(char[] c, int idx) {
		for (int i = c.length - 1; i > 0; i--) {
			if (c[i] > c[idx])
				return i;
		}
		return -1;
	}

	public static void run(Scanner in) {
		int queries = Integer.valueOf(in.nextLine());
		for (int i = 0; i < queries; i++) {
			String s = in.nextLine();
			System.out.println(nextString(s));
		}
	}

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {
			String s = "ab";
			System.out.println(nextString(s));
		}
	}
}
