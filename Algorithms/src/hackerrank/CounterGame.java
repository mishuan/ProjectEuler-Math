package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counter-game
 */
public class CounterGame {
  public static final boolean TEST = false;
  public static int T;

  public static void run(Scanner in) {
    T = in.nextInt();
    for (int i = 0; i < T; i++) {
      in.nextLine();
      BigInteger N = new BigInteger(in.next());
      counterGame(N);
    }
  }

  public static void counterGame(BigInteger N) {
    int counter = 0;

    while (!N.equals(BigInteger.ONE)) {
      String n_1 = N.subtract(BigInteger.ONE).toString(2);
      if (!n_1.contains("0")) {
        N = N.divide(BigInteger.valueOf(2));
      } else {
        String n = N.toString(2).substring(1).trim();
        N = new BigInteger(n, 2);
      }
      counter++;
    }
    String name = counter % 2 == 1 ? "Louise" : "Richard";
    System.out.println(name);
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
