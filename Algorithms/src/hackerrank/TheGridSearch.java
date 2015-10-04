package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 * FAILING TEST CASE #5
 */

public class TheGridSearch {
  public static final boolean TEST = false;
  public static int T;

  public static void run(Scanner in) {
    T = in.nextInt();
    in.nextLine();
    for (int i = 0; i < T; i++) {
      String[] bigArr = createStringArray(in);
      String[] smallArr = createStringArray(in);
      System.out.println(contains(bigArr, smallArr) ? "YES" : "NO");
    }
  }

  public static boolean contains(String[] big, String[] small) {
    for (int i = 0; i < big.length - small.length; i++) {
      int idx = big[i].indexOf(small[0]);
      while (idx != -1) {
        int j = 1;
        for (; j < small.length; j++) {
          int idx2 = big[i + j].indexOf(small[j]);
          if (idx2 != idx) {
            while (idx2 != -1) {
              idx2 = big[i + j].indexOf(small[j], idx2 + 1);
              if (idx2 == idx) break;
            }
            if (idx2 == -1) break;
          }
        }
        if (j == small.length) return true;
        idx = big[i].indexOf(small[0], idx + 1);
      }
    }
    return false;
  }

  public static String[] createStringArray(Scanner in) {
    int r = in.nextInt();
    in.nextLine();
    String[] arr = new String[r];
    for (int i = 0; i < r; i++)
      arr[i] = in.nextLine();
    return arr;
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
