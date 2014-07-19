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

      while (count < 50) {
         poppedNode = queue.poll();
         if (visited[poppedNode[0]] == true)
            continue;
         // Prim's algorithm
         count++;
      }
      System.out.println(totalDistance);
      System.out.println(System.nanoTime() - init);
   }

   public static Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] i1, Integer[] i2) {
         return i1[1] - i2[1];
      }
   };
}
