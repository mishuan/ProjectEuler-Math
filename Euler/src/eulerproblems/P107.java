package eulerproblems;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

import utility.CommonMethods;

public class P107 {

   public static void main(String[] args) throws IOException {
      long init = System.nanoTime();
      String[] rawData = CommonMethods.fileToStringArray("network");
      int dimension = rawData.length;
      int[][] matrix = new int[dimension][dimension];
      for (int i = 0; i < dimension; i++) {
         String[] temp = rawData[i].split(",");
         for (int j = 0; j < dimension; j++) {
            matrix[i][j] = Integer.valueOf(temp[j]);
         }
      }

      PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(dimension, arrayComparator);
      Integer[] pushNode = {0, 0};
      queue.add(pushNode);

      boolean[] visited = new boolean[dimension];
      int count = 0;
      int totalDistance = 0;
      Integer[] poppedNode;
      // Prim's algorithm
      while (count < dimension) {
         poppedNode = queue.poll();

         int position = poppedNode[0];
         if (visited[position] == true)
            continue;

         visited[position] = true;
         totalDistance += poppedNode[1];
         for (int i = 0; i < dimension; i++) {
            int cost = matrix[position][i];
            if (matrix[position][i] == 0 || visited[i])
               continue;
            pushNode = new Integer[2];
            pushNode[0] = i;
            pushNode[1] = cost;
            queue.add(pushNode);
         }
         count++;
      }
      int original = 0;
      for (int[] i : matrix) {
         for (int j : i) {
            original += j;
         }
      }
      System.out.println(original / 2 - totalDistance);
      System.out.println(System.nanoTime() - init);
   }

   public static Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] i1, Integer[] i2) {
         return i1[1] - i2[1];
      }
   };
}
