package hackerrank;

import java.util.Scanner;
//FULL MARKS
public class SecurePasswordSystem {

	public static boolean checkRange(int min, int max) {
		int total = 0;
		for (int i = min; i <= max; i++) {
			total += Math.pow(10d, (double) i);
		}
		return total > 1000000;
	}

	public static void run(Scanner in) {
		int queries = in.nextInt();
		for (int i = 0; i < queries; i++) {
			int min = in.nextInt();
			int max = in.nextInt();
			if (checkRange(min, max))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static final boolean TEST = false;

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {

		}
	}
}
