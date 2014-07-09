package eulerproblems;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import utility.CommonMethods;

public class P083 {
   public static void main(String[] args) throws IOException {
      long init = System.nanoTime();
      String[] rawData = CommonMethods.fileToStringArray("matrix");
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
         if (matrix[poppedArray[0]][poppedArray[1]] < 0)
            continue;
         if (poppedArray[0] == 79 && poppedArray[1] == 79) {
            System.out.println(poppedArray[2]);
            break;
         }

         matrix[poppedArray[0]][poppedArray[1]] = -1;

         if (poppedArray[0] < 79) {
            pushArray = new Integer[3];
            pushArray[0] = poppedArray[0] + 1;
            pushArray[1] = poppedArray[1];
            if (matrix[pushArray[0]][pushArray[1]] > 0) {
               pushArray[2] = poppedArray[2] + matrix[pushArray[0]][pushArray[1]];
               queue.add(pushArray);
            }
         }

         if (poppedArray[1] < 79) {
            pushArray = new Integer[3];
            pushArray[0] = poppedArray[0];
            pushArray[1] = poppedArray[1] + 1;
            if (matrix[pushArray[0]][pushArray[1]] > 0) {
               pushArray[2] = poppedArray[2] + matrix[pushArray[0]][pushArray[1]];
               queue.add(pushArray);
            }
         }
         if (poppedArray[0] > 0) {
            pushArray = new Integer[3];
            pushArray[0] = poppedArray[0] - 1;
            pushArray[1] = poppedArray[1];
            if (matrix[pushArray[0]][pushArray[1]] > 0) {
               pushArray[2] = poppedArray[2] + matrix[pushArray[0]][pushArray[1]];
               queue.add(pushArray);
            }
         }

         if (poppedArray[1] > 0) {
            pushArray = new Integer[3];
            pushArray[0] = poppedArray[0];
            pushArray[1] = poppedArray[1] - 1;
            if (matrix[pushArray[0]][pushArray[1]] > 0) {
               pushArray[2] = poppedArray[2] + matrix[pushArray[0]][pushArray[1]];
               queue.add(pushArray);
            }
         }
      }
      System.out.println(System.nanoTime() - init);
   }

   public static Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {
      @Override
      public int compare(Integer[] i1, Integer[] i2) {
         return i1[2] - i2[2];
      }
   };
}
