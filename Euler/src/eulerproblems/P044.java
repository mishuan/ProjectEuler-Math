package eulerproblems;

import utility.CommonMethods;

public class P044 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int solution = 0;
      int i = 1;
      while (solution == 0) {
         int a = i * (i * 3 - 1) / 2;
         for (int j = 1; j < i; j++) {
            int b = j * (j * 3 - 1) / 2;
            if (CommonMethods.isPentagonal(a + b) && CommonMethods.isPentagonal(a - b)) {
               solution = a - b;
               break;
            }
         }
         i++;
      }
      System.out.println(solution);

      solution = 0;
      i = 1;
      while (solution == 0) {
         int a = i * (i * 3 - 1) / 2;
         for (int j = i - 1; j > 0; j--) {
            int b = j * (j * 3 - 1) / 2;
            if (CommonMethods.isPentagonal(a + b) && CommonMethods.isPentagonal(a - b)) {
               solution = a - b;
               break;
            }
         }
         i++;
      }
      System.out.println(solution);
   }
}
