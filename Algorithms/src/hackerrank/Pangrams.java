package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {
  public static final boolean TEST = false;

  public static void run(Scanner in) {
    System.out.println(isPangram(in.nextLine()) ? "pangram" : "not pangram");
  }

  public static boolean isPangram(String s) {
    s = s.replaceAll("\\s+", "").toLowerCase();
    int bitmask = 0;
    for (char c : s.toCharArray())
      bitmask = bitmask | (1 << (c - 'a'));
    return bitmask == 67108863 ? true : false;
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
