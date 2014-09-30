package eulerproblems;

import utility.CommonMethods;

public class P050 {

   public static void main(String[] args) {
      boolean[] isPrime = CommonMethods.primeGenerator(1000000);
      int[] primes = CommonMethods.getPrimeArray(isPrime);
      int length = primes.length;
      long[] sum = new long[length + 1];
      for (int i = 0; i < length; i++) {
         sum[i + 1] = primes[i] + sum[i];
      }
      int chainLength = 0;
      int solution = 0;
      for (int i = length; i > 0; i--) {
         for (int j = 1; j <= length; j++) {
            long num = sum[i] - sum[j];
            if (num < 1000000l && num > 0) {
               if (isPrime[(int) num]) {
                  if (i - j > chainLength) {
                     chainLength = i - j;
                     solution = (int) num;
                  }
               }
            }
         }
      }
      System.out.println(solution);
   }
}
