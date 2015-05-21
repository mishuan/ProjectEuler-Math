package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
//FULL MARKS
public class BigFileSystemSearch {
	static int[][] files;

	public static void appendFile(int row, String[] s) {
		files[row] = new int[s.length - 1];
		for (int i = 0; i < s.length - 1; i++)
			files[row][i] = Integer.valueOf(s[i + 1]);
		Arrays.sort(files[row]);
	}

	public static void runQuery(String[] s) {
		int queryType = Integer.valueOf(s[0]);
		int[] queryArr = genQueryArray(s);
		switch (queryType) {
		case 1:
			queryAll(queryArr);
			break;
		case 2:
			queryAny(queryArr);
			break;
		case 3:
			querySome(queryArr);
			break;
		}
	}

	private static int[] genQueryArray(String[] s) {
		int size = s.length - 2;
		int[] queryArr = new int[size];
		for (int i = 0; i < size; i++)
			queryArr[i] = Integer.valueOf(s[i + 2]);
		Arrays.sort(queryArr);
		return queryArr;
	}

	private static int query(int[] file, int[] arr) {
		int idxf = 0;
		int idxa = 0;
		int counter = 0;
		while (idxf < file.length && idxa < arr.length) {
			int fileNum = file[idxf];
			int arrNum = arr[idxa];
			if (fileNum == arrNum) {
				counter++;
				idxf++;
				idxa++;
			} else if (fileNum < arrNum)
				idxf++;
			else if (fileNum > arrNum)
				idxa++;
		}
		return counter;
	}

	private static void querySome(int[] arr) {
		int total = 0;
		for (int[] file : files) {
			int counter = query(file, arr);
			if (counter > 0 && counter < arr.length)
				total++;
		}
		System.out.println(total);
	}

	private static void queryAny(int[] arr) {
		int total = 0;
		for (int[] file : files) {
			int counter = query(file, arr);
			if (counter > 0)
				total++;
		}
		System.out.println(total);
	}

	private static void queryAll(int[] arr) {
		int total = 0;
		for (int[] file : files) {
			int counter = query(file, arr);
			if (counter == arr.length)
				total++;
		}
		System.out.println(total);
	}

	public static void run(Scanner in) {
		int numOfFiles = in.nextInt();
		files = new int[numOfFiles][];
		in.nextLine();
		for (int i = 0; i < numOfFiles; i++) {
			String[] s = in.nextLine().split(" ");
			appendFile(i, s);
		}
		int numOfQueries = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numOfQueries; i++) {
			String[] s = in.nextLine().split(" ");
			runQuery(s);
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
