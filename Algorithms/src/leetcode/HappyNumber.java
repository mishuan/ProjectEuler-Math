package leetcode;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

  public static boolean isHappy(int n) {
    HashSet<Integer> curr = new HashSet<>();
    curr.add(n);

    n = convert(n);
    while (!curr.contains(n)) {
      curr.add(n);
      n = convert(n);
    }
    return curr.contains(1) ? true : false;
  }

  public static int convert(int n) {
    int[] squares = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    int sum = 0;
    while (n > 0) {
      sum += squares[n % 10];
      n /= 10;
    }
    return sum;
  }

  public static void main(String args[]) {
    System.out.println(isHappy(3));
  }
}
