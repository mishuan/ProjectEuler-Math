package utility;


final public class CommonMethods {
   // change to return bit array to improve run time
   // All primes are 6n+-1, implement to improve run time
   // Create another int array to hold prime values to improve run time
   static public boolean[] primeGenerator(int limit) throws Exception {
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

}
