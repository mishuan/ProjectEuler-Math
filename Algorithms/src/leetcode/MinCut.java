package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class MinCut {
  public int minCut(String s) {
    return minCutDP1(s);
  }

  public List<Integer> partition(String s) {
    List<Integer> list = new ArrayList<>();
    recurse(list, s, 0);
    return list;
  }

  public void recurse(List<Integer> list, String s, int len) {
    if (s.length() == 0) {
      list.add(len);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      String curr = s.substring(0, i + 1);
      if (isPal(curr))
        recurse(list, s.substring(i + 1), len + 1);
    }
  }

  public boolean isPal(String s) {
    for (int i = 0; i < s.length() / 2; i++)
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    return true;
  }

  public int minCutDP1(String s) {
    int len = s.length();
    int[] cuts = new int[len];
    boolean[][] pal = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      cuts[i] = i - 1;
      for (int j = i; j >= 0; j--) {
        if (s.charAt(i) == s.charAt(j) && (i - j < 2 || pal[j + 1][i - 1])) {
          pal[j][i] = true;
          if (j == 0) cuts[i] = 0;
          else if (cuts[j - 1] + 1 < cuts[i]) cuts[i] = cuts[j - 1] + 1;
        }
      }
    }
    return cuts[len - 1];
  }
}
