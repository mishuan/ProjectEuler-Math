package eulerproblems;

import java.io.IOException;

import utility.SudokuSearch;

public class P096 {

   public static void main(String[] args) throws IOException {
      SudokuSearch oracle = new SudokuSearch();
      System.out.println(oracle.search("003020600900305001001806400008102900700000008006708200002609500800203009005010300"));
   }
}
