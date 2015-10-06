package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-similarity
 */
public class StringSimilarity {
  public static final boolean TEST = false;
  public static int T;

  public static void run(Scanner in) {
    T = Integer.parseInt((in.nextLine()));
    for (int i = 0; i < T; i++)
      System.out.println(countSimilarities(in.nextLine()));
  }

  public static long countSimilarities(String s) {
    char[] c = s.toCharArray();
    int len = c.length;
    int[] z = new int[len];
    int l = 0;
    int r = 0;
    for (int i = 1; i < len; i++) {
      if (i <= r)
        z[i] = Math.min(r - i + 1, z[i - l]);
      while (i + z[i] < len && c[z[i]] == c[z[i] + i])
        z[i]++;
      if (z[i] + i - 1 > r) {
        r = z[i] + i - 1;
        l = i;
      }
    }
    long count = 0;
    for (int i : z)
      count += i;
    return count + len;
  }

  public static void main(String[] args) {
    if (!TEST) {
      Scanner in = new Scanner(System.in);
      run(in);
      in.close();
    } else {
      Scanner in = new Scanner("1\nabbdaecedaadabbbdd\n");
      run(in);
    }
  }
}
