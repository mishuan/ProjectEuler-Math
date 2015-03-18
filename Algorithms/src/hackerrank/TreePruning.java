package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class TreePruning {

	static boolean[][] matrix;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] vals;
	static int[] cacheVals;
	static int numNodes;
	static int operations;

	public static void build(int curr, int parent) {

		for (int i = 0; i < numNodes; i++) {
			if (matrix[curr][i] == true && i != parent)
				build(i, curr);
		}
		tree.get(parent).add(curr);
	}

	public static void constructTree() {
		tree = new ArrayList<ArrayList<Integer>>(numNodes);
		for (int i = 0; i < numNodes; i++)
			tree.add(new ArrayList<Integer>());
		build(0, 0);
		tree.get(0).remove(tree.get(0).size() - 1);
	}

	public static void run(Scanner in) {
		numNodes = in.nextInt();
		operations = in.nextInt();
		matrix = new boolean[numNodes][numNodes];
		vals = new int[numNodes];
		cacheVals = new int[numNodes];

		in.nextLine();
		String[] s = in.nextLine().split(" ");
		for (int i = 0; i < numNodes; i++)
			vals[i] = Integer.valueOf(s[i]);

		for (int i = 1; i < numNodes; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			matrix[x][y] = true;
			matrix[y][x] = true;
		}
	}

	public static final boolean TEST = false;

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {
			// test stuff if my shit is bad
		}
	}

	public static void printArray(ArrayList<ArrayList<Integer>> arr) {
		System.out.println("Printing ArrayList... ");
		for (ArrayList<Integer> l : arr) {
			System.out.print(l.toString());
			System.out.println();
		}
	}

	public static void printArray(int[][] arr) {
		System.out.println("Printing int[][]... ");
		for (int[] a : arr) {
			for (int i : a)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	public static void printArray(int[] arr) {
		System.out.println("Printing int[]... ");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printArray(boolean[][] arr) {
		System.out.println("Printing boolean array... ");
		for (boolean[] a : arr) {
			for (boolean i : a) {
				if (i)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}
}
