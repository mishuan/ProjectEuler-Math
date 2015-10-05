package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram
 */

public class Anagram {
  public static final boolean TEST = false;
  public static int T;

  public static void run(Scanner in) {
    T = Integer.parseInt(in.nextLine());
    for (int i = 0; i < T; i++) {
      String s = in.nextLine();
      System.out.println(anagram(s));
    }
  }

  public static int anagram(String s) {
    if (s.length() % 2 == 1)
      return -1;
    String s1 = s.substring(0, s.length() / 2);
    String s2 = s.substring(s.length() / 2);
    int[] alpha = new int[26];
    int counter = 0;
    for (char c : s1.toCharArray())
      alpha[c - 'a']++;
    for (char c : s2.toCharArray())
      if (alpha[c - 'a'] != 0)
        alpha[c - 'a']--;
      else
        counter++;
    return counter;
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
