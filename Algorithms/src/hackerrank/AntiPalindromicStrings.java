package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class AntiPalindromicStrings {

	public static int antiStrings(int n, int m) {
		if (n > m && m <= 2)
			return 0;
		if (n == 1)
			return m;
		BigInteger len = BigInteger.valueOf(n);
		BigInteger options = BigInteger.valueOf(m);
		BigInteger result = options.subtract(BigInteger.valueOf(2));
		result = result.modPow(len.subtract(BigInteger.valueOf(2)),
				BigInteger.valueOf(1000000007));
		result = result.multiply(options);
		result = result.multiply(options.subtract(BigInteger.ONE));
		return result.mod(BigInteger.valueOf(1000000007)).intValue();
	}

	public static void run(Scanner in) {
		int queries = Integer.valueOf(in.nextLine());
		for (int i = 0; i < queries; i++) {
			int length = in.nextInt();
			int options = in.nextInt();
			System.out.println(antiStrings(length, options));
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
}
