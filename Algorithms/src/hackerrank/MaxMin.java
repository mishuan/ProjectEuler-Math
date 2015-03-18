package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	static ArrayList<Integer> array;
	public static final boolean TEST = false;

	public static void run(Scanner in) {
		int length = Integer.valueOf(in.nextLine());
		int k = Integer.valueOf(in.nextLine()) - 1;
		int min = Integer.MAX_VALUE;
		int[] array = new int[length];

		for (int i = 0; i < length; i++)
			array[i] = Integer.valueOf(in.nextLine());

		Arrays.sort(array);

		for (int i = k; i < length; i++) {
			int diff = array[i] - array[i - k];
			if (diff < min)
				min = diff;
		}
		System.out.println(min);
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
