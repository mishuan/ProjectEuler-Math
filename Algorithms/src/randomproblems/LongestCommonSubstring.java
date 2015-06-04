package randomproblems;

public class LongestCommonSubstring {
   public static int findLongestSubstring(String s1, String s2) {
      char[] seq1 = s1.toCharArray();
      char[] seq2 = s2.toCharArray();
      int seq1Length = seq1.length;
      int seq2Length = seq2.length;
      int[][] grid = new int[seq1Length + 1][seq2Length + 1];
      int largestSequence = 0;
      for (int i = 0; i < seq1Length; i++) {
         for (int j = 0; j < seq2Length; j++) {
            if (seq1[i] == seq2[j]) {
               int x = i + 1;
               int y = j + 1;
               grid[x][y] = 1 + grid[i][j];
               if (grid[x][y] > largestSequence)
                  largestSequence = grid[x][y];
            }
         }
      }
      for (int i = 0; i < seq1Length; i++) {
         for (int j = 0; j < seq2Length; j++)
            System.out.print(grid[i][j] + " ");
         System.out.println();
      }
      return largestSequence;
   }

   public static void main(String[] args) {
      System.out.println(findLongestSubstring("bdabcd", "dbeabcf"));
   }
}
