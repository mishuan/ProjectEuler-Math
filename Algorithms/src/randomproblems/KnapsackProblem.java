package randomproblems;

public class KnapsackProblem {
   public static int findMaxWeight(int[][] items, int maxWeight) {
      int numOfItems = items.length;
      int[][] grid = new int[numOfItems + 1][maxWeight + 1];

      for (int i = 0; i < numOfItems; i++) {
         for (int j = 0; j < maxWeight + 1; j++) {
            int currWeight = items[i][0];
            int currValue = items[i][1];
            int prevValue = j - currWeight < 0 ? 0 : grid[i][j - currWeight] + currValue;

            grid[i + 1][j] = Math.max(grid[i][j], prevValue);
         }
      }
      for (int[] array : grid) {

         for (int i : array) {
            System.out.print(i + " ");
         }
         System.out.println();
      }
      return grid[numOfItems][maxWeight];
   }

   public static void main(String[] args) {
      int[][] items = new int[6][2];
      items[0][0] = 4;
      items[0][1] = 6;
      items[1][0] = 2;
      items[1][1] = 4;
      items[2][0] = 3;
      items[2][1] = 5;
      items[3][0] = 1;
      items[3][1] = 3;
      items[4][0] = 6;
      items[4][1] = 9;
      items[5][0] = 4;
      items[5][1] = 7;
      System.out.println(findMaxWeight(items, 10));
   }
}
