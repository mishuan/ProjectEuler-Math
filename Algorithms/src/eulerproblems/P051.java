package eulerproblems;

import utility.CommonMethods;

public class P051 {

   public static void main(String[] args) {
      boolean[] isPrimes = CommonMethods.primeGenerator(1000000);
      outer: for (int i = 100000; i < isPrimes.length; i++) {
         if (isPrimes[i]) {
            int temp = i / 10;
            int[] digits = new int[3];
            while (temp > 0) {
               int cur = temp % 10;
               if (cur < 3) {
                  digits[cur]++;
               }
               temp /= 10;
            }
            for (int j = 0; j < 3; j++) {
               if (digits[j] == 3) {
                  temp = i / 10;
                  int multiplier = 10;
                  int number = 0;
                  while (temp > 0) {
                     if (temp % 10 == j) {
                        number += multiplier;
                     }
                     temp /= 10;
                     multiplier *= 10;
                  }
                  int chances = 0;
                  for (int k = 1; k <= 9 - j; k++) {
                     int primeChecker = i + k * number;
                     if (!isPrimes[primeChecker])
                        chances++;
                  }
                  if (chances == 2 - j) {
                     System.out.println(i);
                     break outer;
                  }
               }
            }
         }
      }
   }
}
