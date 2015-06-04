package randomproblems;

import java.util.Arrays;
import java.util.Comparator;


/*
 * You have a set of envelopes of different widths and heights. One envelope can fit into another if
 * and only if both the width and height of one envelope is greater than the width and height of the
 * other envelope. What is the maximum number of envelopes can you Russian doll?
 */
public class EnvelopeProblem {
   /*
    * This is essentially the longest increasing subsequence problem after we sort it and remove one
    * of the paramters
    */
   public static void main(String[] args) {
      // 1 7 2 5 3 4 9 5 6 13 9 10 11 14
      // 2 8 9 10 11 12 13 14 15 16 17 18 19 20
      // output: 1 2 3 4 5 6 9 10 11 14
      String input = "20 14 10 18 19 11 15 6 13 16 9 17 5 14 11 3 12 4 5 10 2 9 8 7 1 2";
      int[][] inArray = converToArray(input);
      solveEnvelopeProblem(inArray);
   }

   private static void solveEnvelopeProblem(int[][] inArray) {
      Arrays.sort(inArray, new EnveplopeComparator());
      int[] arr = new int[inArray.length];
      for (int i = 0; i < inArray.length; i++)
         arr[i] = inArray[i][1];
      System.out.println(findLongestIncreasingSubsequenceN2(arr));
   }

   private static int findLongestIncreasingSubsequenceN2(int[] arr) {
      int len = arr.length;

      int[] dp = new int[len];
      dp[0] = 1;
      int maxLen = Integer.MIN_VALUE;

      for (int i = 1; i < len; i++) {
         dp[i] = 1;
         for (int j = i - 1; j >= 0; j--)
            if (dp[j] + 1 > dp[i] && arr[j] < arr[i])
               dp[i] = dp[j] + 1;
         if (maxLen < dp[i])
            maxLen = dp[i];
      }
      return maxLen;
   }

   private static class EnveplopeComparator implements Comparator<int[]> {
      @Override
      public int compare(int[] o1, int[] o2) {
         if (o1[0] > o2[0])
            return 1;
         if (o1[0] < o2[0])
            return -1;
         return 0;
      }
   }

   private static int[][] converToArray(String input) {
      String[] inputs = input.split(" ");
      int[][] array = new int[inputs.length / 2][];
      for (int i = 0; i < inputs.length / 2; i++) {
         array[i] = new int[2];
         int a = Integer.valueOf(inputs[i * 2]);
         int b = Integer.valueOf(inputs[i * 2 + 1]);
         if (a > b) {
            array[i][0] = a;
            array[i][1] = b;
         } else {
            array[i][0] = b;
            array[i][1] = a;
         }
      }
      return array;
   }
}
