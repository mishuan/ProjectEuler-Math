package hackerrank;

import java.util.Scanner;

public class FillingJars {

	static long jars;
	public static final boolean TEST = false;
	static long total;

	public static void run(Scanner in) {
		String[] queries = in.nextLine().split(" ");
		jars = Integer.valueOf(queries[0]);
		int n = Integer.valueOf(queries[1]);
		for (int i = 0; i < n; i++) {
			String[] params = in.nextLine().split(" ");
			long numAdds = Math.abs(Integer.valueOf(params[1])
					- Long.valueOf(params[0])) + 1;
			total = total + Long.valueOf(params[2]) * numAdds;
		}
		System.out.println(total / jars);
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
