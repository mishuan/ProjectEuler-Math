package eulerproblems;

import utility.CommonMethods;

public class P357 {
   static boolean[] primeBool = CommonMethods.primeGenerator(100000000);

   public static boolean check(int n) {
      for (int j = 2; j < Math.sqrt(n); j++) {
         if (n % j == 0 && !primeBool[j + n / j])
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      int sum = 0;
      for (int i = 1; i < 100000000; i += 2) {
         if (check(i))
            sum += i;
      }
      System.out.println(sum);
   }
}
