package hackerrank;

import java.util.*;

public class IsFibo {

	public static final boolean TEST = true;
	public static ArrayList<Long> fib;

	public static boolean isFibo(Long n) {
		if (fib == null) {
			fib = new ArrayList<Long>();
			fib.add(0l);
			fib.add(1l);
		}
		if (fib.get(fib.size() - 1) < n)
			return extendAndCompare(n);
		return 0 <= Collections.binarySearch(fib, n);
	}

	public static boolean extendAndCompare(Long n) {
		int i = fib.size() - 2;
		long last = fib.get(fib.size() - 1);
		while (n > last) {
			last += fib.get(i);
			fib.add(last);
			i++;
		}
		return last == n;
	}

	public static void run(Scanner in) {

		long queries = Long.valueOf(in.nextLine());

		for (int i = 0; i < queries; i++) {
			long n = Long.valueOf(in.nextLine());
			if (isFibo(n))
				System.out.println("IsFibo");
			else
				System.out.println("IsNotFibo");
		}
	}

	public static void main(String[] args) {
		if (!TEST) {
			Scanner in = new Scanner(System.in);
			run(in);
			in.close();
		} else {
			isFibo(100000l);
			System.out.println(fib);
		}
	}
}
