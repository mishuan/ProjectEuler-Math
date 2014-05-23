package eulerproblems;

import utility.CommonMethods;

public class P035 {

   public static void main(String[] args) throws Exception {
      boolean[] primes = CommonMethods.primeGenerator(1000000);
      int totalPrimes = 13;
      for (int i = 100; i < 1000000; i++) {
         if (primes[i]) {
            String temp = String.valueOf(i);
            int digits = temp.length();
            int counter = 1;
            int primeInQuestion = i;
            while (counter < digits) {
               int swapDigit = primeInQuestion % 10;
               if (swapDigit % 2 == 0)
                  break;
               for (int k = 1; k < digits; k++) {
                  swapDigit *= 10;
               }
               primeInQuestion = primeInQuestion / 10 + swapDigit;
               if (primes[primeInQuestion]) {
                  counter++;
               } else {
                  break;
               }
            }
            if (counter == digits) {
               totalPrimes++;
            }
         }
      }
      System.out.println(totalPrimes);
   }
}
