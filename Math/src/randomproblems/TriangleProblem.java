package randomproblems;

import java.util.ArrayList;
import java.util.List;

import utility.CommonMethods;

/**
 * Find the number of triangles in a file:
 * 
 * ooxoo 
 * oxxxo 
 * xxxxx
 * 
 * Constitutes a triangle. Count upwards and upside down triangles.
 * 
 * @author Michael Yuan
 * 
 */
public class TriangleProblem {
   public static void main(String[] args) throws Exception {
      // create the grid in a matrix
      long init = System.nanoTime();
      int size = 2500;
      int counter = 0;
      List<Integer[]> values = new ArrayList<Integer[]>();
      String[] originalFile = CommonMethods.fileToStringArray("TriangleLarge");
      int[][] matrix = new int[size][size];
      for (int i = 0; i < size; i++) {
         int rowCounter = 0;
         for (int j = 0; j < size; j++) {
            int n = originalFile[i].charAt(j) - '0';
            if (n != 0) {
               rowCounter++;
               counter++;
               if (j != 0 && j != size - 1 && i != size - 1)
                  values.add(new Integer[] {i, j});
            } else {
               rowCounter = 0;
            }
            matrix[i][j] = rowCounter;
         }
      }

      System.out.println("Matrix generation: " + (System.nanoTime() - init));
      int maxHeight = (size + 1) / 2;
      for (int h = 1; h < maxHeight; h++) {
         List<Integer[]> newValues = new ArrayList<Integer[]>();
         for (Integer[] curr : values) {
            int baseValue = (h + 1) * 2 - 1;
            int baseY = curr[0] + h;
            int baseX = curr[1] + h;
            if (matrix[baseY][baseX] >= baseValue) {
               counter++;
               if (curr[1] > h && curr[1] < size - h - 1 && curr[0] < size - h - 1)
                  newValues.add(curr);
            }
         }
         values = newValues;
      }
      System.out.println("Finding triangles took total: " + (System.nanoTime() - init));
      System.out.println(counter);
   }
}
