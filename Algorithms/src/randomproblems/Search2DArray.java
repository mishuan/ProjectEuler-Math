package randomproblems;


public class Search2DArray {
   public static int[] searchLinear(int[][] matrix, int value) {
      int[] index = new int[2];
      int m = matrix.length;
      int n = matrix[0].length;

      int i = m - 1;
      int j = 0;
      while (i >= 0 && j < n) {
         if (matrix[i][j] > value) {
            i--;
         } else if (matrix[i][j] < value) {
            j++;
         } else {
            index[0] = i;
            index[1] = j;
            return index;
         }
      }
      return null;
   }

   public static void main(String[] args) {
      int[][] matrix = new int[7][10];
      for (int i = 0; i < 7; i++) {
         for (int j = 0; j < 10; j++) {
            matrix[i][j] = i * 10 + j;
            System.out.print(matrix[i][j] + " ");
         }
         System.out.println();
      }
      int[] indices = searchLinear(matrix, 19);
      System.out.println((indices[0] == 1) + " " + (indices[1] == 9));
   }
}
