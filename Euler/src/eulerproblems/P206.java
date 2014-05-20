package eulerproblems;

public class P206 {

	public static void main(String[] args) {
		for (long i = 138902673; i > 101010101; i -= 2) {
			long product = i * i;
			long j = 9;
			while (j > 0) {
				int mod = (int) (product % 10l);
				if (mod != j) {
					break;
				}
				product /= 100l;
				j--;
			}
			if (j == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
