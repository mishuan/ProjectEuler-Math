package eulerproblems;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import utility.CommonMethods;

public class P082 {

   public static void main(String[] args) throws IOException {
      String[] rawData = CommonMethods.fileToStringArray("matrix2");
      int[][] matrix = new int[80][80];
      for (int i = 0; i < 80; i++) {
         String[] split = rawData[i].split(",");
         for (int j = 0; j < 80; j++) {
            matrix[i][j] = Integer.valueOf(split[j]);
         }
      }
      Queue<Integer[]> queue = new PriorityQueue<Integer[]>(6400, arrayComparator);
      Integer[] pushArray = new Integer[3];
      pushArray[0] = 0;
      pushArray[1] = 0;
      pushArray[2] = matrix[0][0];
      queue.add(pushArray);
      Integer[] poppedArray;
      while ((poppedArray = queue.poll()) != null) {


      }
   }

   public static Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] i1, Integer[] i2) {
         return i1[2] - i2[2];
      }
   };

}
