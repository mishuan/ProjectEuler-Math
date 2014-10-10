package randomproblems;

import java.util.ArrayList;
import java.util.HashSet;

import utility.ImmutablePair;

public class TwoNumberSums {
   public static ArrayList<ImmutablePair<Integer, Integer>> getPairSums(int[] array, int sumValue) {
      ArrayList<ImmutablePair<Integer, Integer>> pairs = new ArrayList<ImmutablePair<Integer, Integer>>();
      HashSet<Integer> differences = new HashSet<Integer>();
      HashSet<ImmutablePair<Integer, Integer>> pairSet = new HashSet<ImmutablePair<Integer, Integer>>();
      for (int i : array)
         differences.add(sumValue - i);

      for (int i : array) {
         int diff = sumValue - i;
         if (differences.contains(i)) {
            ImmutablePair<Integer, Integer> newPair =
                  diff < i ? new ImmutablePair<Integer, Integer>(diff, i) : new ImmutablePair<Integer, Integer>(i, diff);
            pairSet.add(newPair);
         }

      }
      pairs.addAll(pairSet);
      return pairs;
   }

   public static void main(String[] args) {
      int[] nums = {3, 2, 6, 2, 0, 5, 3, 8, 7, 10};
      System.out.println(getPairSums(nums, 10));
   }
}
