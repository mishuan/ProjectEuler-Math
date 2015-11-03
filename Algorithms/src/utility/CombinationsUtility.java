package utility;

import java.util.ArrayList;

/**
 * Utility class to calculate combinations
 */
public class CombinationsUtility {
  public static ArrayList<String> getCombinations(String s, int k) {
    if (k > s.length()) return null;
    char[] arr = s.toCharArray();
    ArrayList<String> list = new ArrayList<>();
    getCombinationsHelper(0, 0, k, "", arr, list);
    return list;
  }

  private static void getCombinationsHelper(int i, int n, int k, String s, char[] arr, ArrayList<String> list) {
    if (n == k) {
      list.add(s);
      return;
    }
    for (int j = i; j < arr.length; j++)
      getCombinationsHelper(j + 1, n + 1, k, s + arr[j], arr, list);
  }

  public static long choose(long n, long r) {
    if (n < r) return 0;
    if (r == 0 || r == n) return 1;
    return choose(n - 1, r - 1) + choose(n - 1, r);
  }

  public static void main(String[] args) {
    System.out.println(getCombinations("abcdef", 3).size());
  }
}
