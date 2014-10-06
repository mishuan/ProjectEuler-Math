package randomproblems;

public class LongestCommonSubsequence {
   public static int findLongestSubsequence(String s1, String s2) {
      char[] seq1 = s1.toCharArray();
      char[] seq2 = s2.toCharArray();
      int seq1Length = seq1.length;
      int seq2Length = seq2.length;
      int[][] grid = new int[seq1Length + 1][seq2Length + 1];
      for (int i = 0; i < seq1Length; i++) {
         for (int j = 0; j < seq2Length; j++) {
            int x = i + 1;
            int y = j + 1;
            if (seq1[i] == seq2[j])
               grid[x][y] = 1 + grid[i][j];
            else
               grid[x][y] = Math.max(grid[i][y], grid[x][j]);
         }
      }
      return grid[seq1Length][seq2Length];
   }

   public static void main(String[] args) {
      System.out.println(findLongestSubsequence("ayuanbc","yabuanc"));
   }
}
