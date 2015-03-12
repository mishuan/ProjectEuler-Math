package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class SupermanCelebratesDiwali {

	static int height;
	static int heightLoss;
	static int buildings;
	static int matrix[][];
	static int dp[][];
	static int maxDP[];

	public static int search() {
		dp[0] = matrix[0];
		for (int h = 1; h < height; h++) {
			int ph = h - 1;
			int nh = h - heightLoss;
			for (int w = 0; w < buildings; w++) {
				if (nh >= 0) {
					int val = dp[ph][w] + matrix[h][w];
					int prevMax = cacheMax(nh) + matrix[h][w];
					dp[h][w] = val > prevMax ? val : prevMax;
				} else
					dp[h][w] = dp[ph][w] + matrix[h][w];
			}
		}
		return max(dp[height - 1]);
	}

	public static int cacheMax(int h) {
		if (maxDP[h] == -1)
			maxDP[h] = max(dp[h]);
		return maxDP[h];
	}

	public static int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i : array) {
			if (i > max)
				max = i;
		}
		return max;
	}

	public static void run(Scanner in) {

		buildings = in.nextInt();
		height = in.nextInt();
		heightLoss = in.nextInt();
		matrix = new int[height][buildings];
		dp = new int[height][buildings];
		maxDP = new int[height];
		Arrays.fill(maxDP, -1);

		for (int i = 0; i < buildings; i++) {
			in.nextLine();
			int numOfPeople = in.nextInt();
			for (int p = 0; p < numOfPeople; p++)
				matrix[in.nextInt() - 1][i]++;
		}
		
		long t1 = System.nanoTime();
		System.out.println(search());
		long t2 = System.nanoTime();
		if (TEST)
			System.out.println("Search time: " + (t2 - t1) / 1e6);
	}

	public static final boolean TEST = false;

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {
			//test stuff if my shit is bad
		}
	}
}
