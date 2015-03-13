package randomproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class SubtreesAndPaths {

	static boolean[][] matrix;
	static ArrayList<ArrayList<Integer>> tree;
	static int[][] relations;
	static int numNodes;
	static int numQueries;
	static int[] vals;
	static ArrayList<Integer> rents;

	public static int search() {
		return 0;
	}

	public static void addValue(int n, int v) {
		ArrayList<Integer> curr = tree.get(n);
		for (int i = 0; i < curr.size(); i++)
			addValue(curr.get(i), v);
		vals[n] += v;
	}

	public static void build(int curr, int parent) {
		rents.add(curr);
		for (int i = 0; i < numNodes; i++) {
			if (matrix[curr][i] == true && i != parent) {
				for (int p : rents) {
					relations[p][i] = curr;
					System.out.println("p = " + p + " i = " + i + " curr = " + curr);
				}
				build(i, curr);
				rents.remove(rents.size() - 1);
			}
		}
		tree.get(parent).add(curr);
	}

	public static void constructTree() {
		rents = new ArrayList<Integer>(numNodes);
		tree = new ArrayList<ArrayList<Integer>>(numNodes);
		for (int i = 0; i < numNodes; i++)
			tree.add(new ArrayList<Integer>());
		build(0, 0);
		tree.get(0).remove(tree.get(0).size() - 1);
	}

	public static void run(Scanner in) {
		numNodes = in.nextInt();
		matrix = new boolean[numNodes][numNodes];
		relations = new int[numNodes][numNodes];
		vals = new int[numNodes];

		for (int i = 1; i < numNodes; i++) {
			in.nextLine();
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			matrix[x][y] = true;
			matrix[y][x] = true;
		}

		printArray(matrix);
		constructTree();
		printArray(tree);
		printArray(relations);

		in.nextLine();
		numQueries = in.nextInt();
		in.nextLine();

		for (int i = 0; i < numQueries; i++) {
			String[] params = in.nextLine().split(" ");

			if (params[0].equals("add")) {
				addValue(Integer.valueOf(params[1]) - 1, Integer.valueOf(params[2]));
				printArray(vals);
			} else {
				// System.out.println(search());
			}
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
