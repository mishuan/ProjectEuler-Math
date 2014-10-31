package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class DortmundDilemma {
   static int[] combs = new int[27];
   static BigInteger MOD_CONST = BigInteger.valueOf(1000000009);
   static long MOD_CONST_LONG = 1000000009;

   public static int possibleNames(int N, int K) {
      long total = 0;

      return (int) (total);
   }

   public static int combinations(int int0, int int1) {
      if (int1 == 0) {
         return 1;
      }
      BigInteger temp = BigInteger.ONE;
      for (int i = int0; i > int1; i--) {
         temp = temp.multiply(BigInteger.valueOf(i));
      }
      BigInteger div = BigInteger.ONE;
      for (int i = 1; i <= int0 - int1; i++) {
         div = div.multiply(BigInteger.valueOf(i));
      }
      return temp.divide(div).mod(MOD_CONST).intValue();
   }

   public static void main(String[] args) {
//      @SuppressWarnings("resource")
//      Scanner in = new Scanner(System.in);
      for (int i = 0; i < 27; i++) {
         combs[i] = combinations(26, i);
      }
//      int numInputs = in.nextInt();
//      for (int i = 0; i < numInputs; i++) {
//         int N = in.nextInt();
//         int K = in.nextInt();
//         System.out.println(possibleNames(N, K));
//      }
      System.out.println(possibleNames(2,2));
   }
}
