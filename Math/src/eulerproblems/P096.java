package eulerproblems;

import java.io.IOException;

import utility.CommonMethods;
import utility.SudokuSearch;

public class P096 {

   public static void main(String[] args) throws IOException {
      SudokuSearch oracle = new SudokuSearch();
      String[] originalFile = CommonMethods.fileToStringArray("sudoku");
      String[] grids = new String[50];
      String s = "";
      int solution = 0;
      for (int i = 1, j = 0; i < 500; i++) {
         if (i % 10 == 0) {
            grids[j] = s;
            j++;
            s = "";
         } else
            s = s + originalFile[i];
      }
      grids[49] = s;
      long init = System.currentTimeMillis();
      for (String sol : grids) {
         solution += Integer.valueOf(oracle.search(sol).substring(0, 3));
      }
      System.out.println("Sum is " + solution + " Found in: " + (System.currentTimeMillis() - init) + "ms");
   }
}
