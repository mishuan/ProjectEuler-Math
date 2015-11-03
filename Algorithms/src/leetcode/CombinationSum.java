package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> list = new LinkedList<>();
    List<Integer> curr = new LinkedList<>();
    recurse(candidates, list, curr, target, 0);
    return list;
  }
  public static void recurse(int[] candidates, List<List<Integer>> list, List<Integer> curr, int n, int idx){
    if(n == 0) list.add(new LinkedList(curr));
    for(int i = idx; i < candidates.length; i++){
      if(n - candidates[i] < 0) return;
      curr.add(candidates[i]);
      recurse(candidates, list, curr, n - candidates[i], i);
      curr.remove(curr.size()-1);
    }
  }
  public static void main(String[] args){
    int[] arr = {2,5,4,1};
    List<List<Integer>> list = combinationSum(arr, 7);
    for (List<Integer> l : list) System.out.println(l.toString());
  }
}
