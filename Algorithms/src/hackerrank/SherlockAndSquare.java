package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class SherlockAndSquare {

	public static BigInteger bigSherlock(int t) {
		BigInteger time = BigInteger.valueOf(t + 1);
		return BigInteger.valueOf(2).modPow(time, BigInteger.valueOf(1000000007)).add(BigInteger.valueOf(2));
	}

	public static void run(Scanner in) {
		int queries = in.nextInt();
		for (int i = 0; i < queries; i++) {
			int t = in.nextInt();
			System.out.println(bigSherlock(t).toString());
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
