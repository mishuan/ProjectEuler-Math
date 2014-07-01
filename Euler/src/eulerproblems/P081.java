package eulerproblems;

import java.io.IOException;

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
   }
}
