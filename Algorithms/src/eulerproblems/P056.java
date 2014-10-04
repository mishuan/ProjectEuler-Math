package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P056 {
   public static void main(String[] args) {
      int digitSum = 0;
      for (int i = 1; i < 100; i++) {
         BigInteger curr = BigInteger.valueOf(i);
         for (int j = 99; j > 0; j--) {
            BigInteger temp = curr.pow(j);
            int tempSum = CommonMethods.digitSum(temp);
            if (tempSum > digitSum)
               digitSum = tempSum;
         }
      }
      System.out.println(digitSum);
   }
}
