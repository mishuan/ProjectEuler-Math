package eulerproblems;

import utility.CommonMethods;

public class P058 {

   public static void main(String[] args) {
      int i = 2;
      int primes = 3;
      int curCorner = 9;
      while ((double) primes / (double) (2 * i + 1) > 0.10d) {
         i += 2;
         for (int j = 0; j < 3; j++) {
            curCorner += i;
            if (CommonMethods.isPseudoPrime(curCorner))
               primes++;
         }
         curCorner += i;
      }
      System.out.println(i + 1);
   }
}
