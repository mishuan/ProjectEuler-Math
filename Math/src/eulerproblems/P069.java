package eulerproblems;

import utility.CommonMethods;

public class P069 {

   public static void main(String[] args) {
      int[] primes = CommonMethods.getPrimeArray(CommonMethods.primeGenerator(1000000));
      int result = 1;
      int index = 0;
      while (result * primes[index] < 1000000) {
         result *= primes[index];
         index++;
      }
      System.out.println(result);
   }
}
