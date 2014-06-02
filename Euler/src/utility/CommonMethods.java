package utility;

import java.util.ArrayList;


final public class CommonMethods {
   static public boolean[] primeGenerator(int limit) {
      boolean[] isPrime = new boolean[limit + 1];
      // Sieve of Eratosthenes
      if (limit >= 2) {
         for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
         }
         int currentInt = 2;
         while (currentInt <= limit) {
            if (isPrime[currentInt] && (long) currentInt * currentInt <= limit) {
               for (int i = currentInt * currentInt; i <= limit; i += currentInt) {
                  isPrime[i] = false;
               }
            }
            currentInt++;
         }
      }
      return isPrime;
   }

   public static ArrayList<Integer> getPrimeList(boolean[] primes) {
      ArrayList<Integer> primesList = new ArrayList<Integer>();
      for (int i = 0; i < primes.length; i++) {
         if (primes[i]) {
            primesList.add(i);
         }
      }
      return primesList;
   }

   public static int[] getPrimeArray(boolean[] primes) {
      int entries = 0;
      for (int i = 0; i < primes.length; i++) {
         if (primes[i])
            entries++;
      }
      int[] array = new int[entries];
      entries = 0;
      for (int i = 0; i < primes.length; i++) {
         if (primes[i]) {
            array[entries] = i;
            entries++;
         }
      }
      return array;
   }

   public static boolean isPandigital(long number) {
      long digits = 0;
      long counter = 0;
      while (number > 0) {
         long temp = digits;
         digits = digits | 1 << (number % 10) - 1;
         if (temp == digits)
            return false;
         counter++;
         number /= 10;
      }
      return digits == (1 << counter) - 1;
   }

   public static boolean isPalindrome(String number) {
      char[] palindrome = number.toCharArray();
      int stringLength = palindrome.length;

      for (int i = 0; i < stringLength / 2; i++) {
         if (palindrome[i] != palindrome[stringLength - 1 - i]) {
            return false;
         }
      }
      return true;
   }

   public static int concat(int a, int b) {
      int c = b;
      while (c > 0) {
         a *= 10;
         c /= 10;
      }
      return a + b;
   }

   public static boolean nextPermutation(int[] p) {
      int a = p.length - 2;
      while (a >= 0 && p[a] >= p[a + 1]) {
         a--;
      }
      if (a == -1) {
         return false;
      }
      int b = p.length - 1;
      while (p[b] <= p[a]) {
         b--;
      }
      int t = p[a];
      p[a] = p[b];
      p[b] = t;
      for (int i = a + 1, j = p.length - 1; i < j; i++, j--) {
         t = p[i];
         p[i] = p[j];
         p[j] = t;
      }
      return true;
   }

   public static boolean isPermutation(int a, int b) {
      int[] array = new int[10];
      while (a > 0) {
         array[a % 10]++;
         a /= 10;
      }
      while (b > 0) {
         array[b % 10]--;
         b /= 10;
      }
      for (int i = 0; i < 10; i++) {
         if (array[i] != 0)
            return false;
      }
      return true;

   }

   public static boolean isTriangle(long n) {
      double index = (Math.sqrt(8 * n + 1) - 1) / 2;
      return index == (int) index;
   }

   public static boolean isPentagonal(long n) {
      double index = (Math.sqrt(24 * n + 1) + 1) / 6;
      return index == (int) index;
   }

   public static boolean isHexagonal(long n) {
      double index = (Math.sqrt(8 * n + 1) + 1) / 4;
      return index == (int) index;
   }
}
