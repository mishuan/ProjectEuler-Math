package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P053 {

   public static void main(String[] args) {
      int oneMil = 0;
      for (int i = 1; i <= 100; i++) {
         for (int j = 1; j < i; j++) {
            if (CommonMethods.combinations(i, j).compareTo(BigInteger.valueOf(1000000)) > 0)
               oneMil++;
         }
      }
      System.out.println(oneMil);
   }
}
