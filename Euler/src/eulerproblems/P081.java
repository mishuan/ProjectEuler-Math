package eulerproblems;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import utility.CommonMethods;

public class P081 {

   public static void main(String[] args) throws IOException {
      String[] rawData = CommonMethods.fileToStringArray("matrix");
      int[][] matrix = new int[80][80];
      for (int i = 0; i < 80; i++) {
         String[] split = rawData[i].split(",");
         for (int j = 0; j < 80; j++) {
            matrix[i][j] = Integer.valueOf(split[j]);
         }
      }
      Queue<Integer[]> queue = new PriorityQueue<Integer[]>(6400, arrayComparator);
      Integer[] pushArray1 = new Integer[3];
      Integer[] pushArray2 = new Integer[3];
      pushArray1[0] = 0;
      pushArray1[1] = 0;
      pushArray1[2] = matrix[0][0];
      queue.add(pushArray1);
      while (true) {
         Integer[] poppedArray = queue.poll();
         System.out.println(poppedArray[2]);
         if (poppedArray[0] == 79 && poppedArray[1] == 79) {
            System.out.println(poppedArray[2]);
            break;
         }
         if (poppedArray[0] < 79) {
            pushArray1[0] = poppedArray[0] + 1;
            pushArray1[1] = poppedArray[1];
            pushArray1[2] = poppedArray[2] + matrix[pushArray1[0]][pushArray1[1]];
            queue.add(pushArray1);
         }
         if (poppedArray[1] < 79) {
            pushArray2[0] = poppedArray[0];
            pushArray2[1] = poppedArray[1] + 1;
            pushArray2[2] = poppedArray[2] + matrix[pushArray2[0]][pushArray2[1]];
            queue.add(pushArray2);
         }
      }
   }

   public static Comparator<Integer[]> arrayComparator = new Comparator<Integer[]>() {

      @Override
      public int compare(Integer[] i1, Integer[] i2) {
         return (int) (i1[2] - i2[2]);
      }
   };
}
