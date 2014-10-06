package randomproblems;

public class LongestCommonSubsequence {
   public static int findLongestSubsequence(String s1, String s2) {
      char[] seq1 = s1.toCharArray();
      char[] seq2 = s2.toCharArray();
      int seq1Length = seq1.length;
      int seq2Length = seq2.length;
      int[][] grid = new int[seq1Length + 1][seq2Length + 1];
      int largestSequence = 0;
      for (int i = 0; i < seq1Length; i++) {
         for (int j = 0; j < seq2Length; j++) {

         }
      }
      return largestSequence;
   }

   public static void main(String[] args) {}
}
