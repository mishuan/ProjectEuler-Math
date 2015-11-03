package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSumIII {
  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> list = new LinkedList<>();
    boolean[] used = new boolean[10];
    recurse(list, used, k, n, 1);
    return list;
  }

  public static void recurse(List<List<Integer>> list, boolean[] used, int k, int n, int idx) {
    if (n == 0 && k == 0) list.add(getList(used));
    if (k <= 0) return;
    for (int i = idx; i < used.length; i++) {
      if (n - i < 0) return;
      if (!used[i]) {
        used[i] = true;
        recurse(list, used, k - 1, n - i, i + 1);
        used[i] = false;
      }
    }
  }

  public static List<Integer> getList(boolean[] used) {
    List<Integer> list = new LinkedList<>();
    for (int i = 1; i < used.length; i++)
      if (used[i]) list.add(i);
    return list;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = combinationSum3(3, 10);
    for (List<Integer> l : list) System.out.println(l.toString());
  }
}
