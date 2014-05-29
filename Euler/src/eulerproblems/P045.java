package eulerproblems;

import utility.CommonMethods;

public class P045 {

   public static void main(String[] args) {
      long solution = 0;
      int i = 144;
      while (true) {
         long n = i * (i * 2 - 1);
         if (CommonMethods.isPentagonal(n)) {
            solution = n;
            break;
         }
         i++;
      }
      System.out.println(solution);
   }
}
