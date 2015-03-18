package randomproblems;

import java.util.Scanner;

public class TwitterProblem1 {
	public static int countSeriesTerm(int a, int d, int b, int r, int lim) {

		int count = 0;

		while (b <= lim) {
			int check = (b - a) / d;
			if (check == Math.floor(check))
				count++;
			b *= r;
		}

		return count;
	}

	public static final boolean TEST = true;

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			int a = Integer.valueOf(in.nextLine().split(" = ")[1]);
			int d = Integer.valueOf(in.nextLine().split(" = ")[1]);
			int b = Integer.valueOf(in.nextLine().split(" = ")[1]);
			int r = Integer.valueOf(in.nextLine().split(" = ")[1]);
			int lim = Integer.valueOf(in.nextLine().split(" = ")[1]);
			System.out.println(countSeriesTerm(a, d, b, r, lim));
			in.close();
		} else {
			System.out.println(countSeriesTerm(1, 1, 3, 3, 1000000000));
		}
	}
}
