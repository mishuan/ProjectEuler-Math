package hackerrank;

import randomproblems.LongestCommonSubsequence;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/common-child
 */
public class CommonChild {
  public static final boolean TEST = false;

  public static void run(Scanner in) {
    String A = in.nextLine();
    String B = in.nextLine();
    System.out.println(LongestCommonSubsequence.findLongestSubsequence(A, B));
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
