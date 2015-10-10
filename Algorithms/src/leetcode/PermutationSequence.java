package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {
  public static String getPermutation(int n, int k) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = i + 1;
    Arrays.sort(arr);
    for (int i = 0; i < k - 1; i++) nextPermutation(arr);
    StringBuffer ret = new StringBuffer(n);
    for (int i : arr) ret.append(i);
    return ret.toString();
  }

  public static boolean nextPermutation(int[] c) {
    int len = c.length;
    int i = len - 2;
    while (i >= 0 && c[i] >= c[i + 1]) i--;
    if (i == -1) return false;
    int j = len - 1;
    while (c[j] <= c[i]) j--;
    int tmp = c[j];
    c[j] = c[i];
    c[i] = tmp;
    for (i = i + 1, j = len - 1; i < j; i++, j--) {
      tmp = c[i];
      c[i] = c[j];
      c[j] = tmp;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(getPermutation(5, 1));
  }
}
