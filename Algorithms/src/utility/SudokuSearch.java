package utility;

import java.util.ArrayList;
import java.util.List;

public class SudokuSearch {

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
      return "Solution not found";
   }

   private boolean recurse(String problem, int i) {
      if (i == emptyEntries.size()) {
         solution = problem;
         return true;
      }
      int currIndex = emptyEntries.get(i);
      boolean[] notCandidate = new boolean[10];
      char[] grid = problem.toCharArray();
      for (int j = 0; j < 81; j++) {
         if (sameRow(currIndex, j) || sameCol(currIndex, j) || sameBlock(currIndex, j)) {
            notCandidate[grid[j] - '0'] = true;
         }
      }
      for (int j = 1; j < 10; j++) {
         if (notCandidate[j])
            continue;
         grid[currIndex] = (char) (((int) '0') + j);
         if (recurse(new String(grid), i + 1))
            return true;
      }
      return false;
   }

   private boolean sameRow(int i, int j) {
      return i / 9 == j / 9;
   }

   private boolean sameCol(int i, int j) {
      return (i - j) % 9 == 0;
   }

   private boolean sameBlock(int i, int j) {
      return i / 27 == j / 27 && i % 9 / 3 == j % 9 / 3;
   }
}
