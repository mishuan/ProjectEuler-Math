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
}
