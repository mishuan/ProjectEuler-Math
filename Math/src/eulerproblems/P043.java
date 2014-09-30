package eulerproblems;

import utility.CommonMethods;


public class P043 {

   public static void main(String[] args) {
      int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
      int[] primes = {2, 3, 5, 7, 11, 13, 17};
      long sum = 0;
      do {
         boolean complete = true;
         for (int i = 7; i > 0; i--) {
            int num = digits[2 + i] + 10 * digits[1 + i] + 100 * digits[i];
            if (num % primes[i - 1] != 0) {
               complete = false;
               break;
            }
         }
         if (complete) {
            long multiplier = 1;
            for (long i = 9; i >= 0; i--) {
               sum += digits[(int) i] * multiplier;
               multiplier *= 10;
            }
         }
      } while (CommonMethods.nextPermutation(digits));
      System.out.println(sum);
   }
}
