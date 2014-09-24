package utility.test;

import static org.junit.Assert.assertEquals;
import static utility.CommonMethods.combinations;
import static utility.CommonMethods.primeGenerator;

import java.math.BigInteger;

import org.junit.Test;

public class CommonMethodsTest {
   @Test
   public void testPrimeGenerator() throws Exception {
      boolean[] isPrime = primeGenerator(2000000);
      long sum = 0;
      for (int i = 0; i <= 2000000; i++) {
         if (isPrime[i]) {
            sum = sum + i;
         }
      }
      assertEquals(142913828922l, sum);
   }

   @Test
   public void test() {
      assertEquals(BigInteger.valueOf(10), combinations(5, 2));
   }

}
