package eulerproblems;

import java.util.ArrayList;
import java.util.List;

public class P096 {

   public static void main(String[] args) {
      SudokuSearch oracle = (new P096()).new SudokuSearch();
      String solved = oracle.search("abc");
   }

   class SudokuSearch {

      List<Integer> emptyEntries;
      String solution;

      public String search(String problem) {
         emptyEntries = new ArrayList<Integer>();
         char[] problemChar = problem.toCharArray();
         for (int i = 0; i < 81; i++) {
            if (problemChar[i] == '0')
               emptyEntries.add(i);
         }
         if (recurse(problem, 0)) {
            return solution;
         }
         return problem;
      }

      public boolean recurse(String problem, int i) {
         if (i == emptyEntries.size()) {
            solution = problem;
            return true;
         }
         return false;
      }

      public boolean sameRow(int i, int j) {
         return i / 9 == j / 9;
      }

      public boolean sameCol(int i, int j) {
         return (i - j) % 9 == 0;
      }

      public boolean sameBlock(int i, int j) {
         return i / 27 == j / 27 && i % 9 / 3 == j % 9 / 3;
      }
   }
}
