package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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

   public static List<Integer> stringToList(String in) {
      String[] strings = in.split(" ");
      List<Integer> list = new ArrayList<Integer>(strings.length);
      for (String s : strings)
         list.add(Integer.valueOf(s));
      return list;
   }

   public static Integer[] stringToInteger(String in) {
      String[] strings = in.split(" ");
      int len = strings.length;
      Integer[] arr = new Integer[len];
      for (int i = 0; i < len; i++)
         arr[i] = Integer.valueOf(strings[i]);
      return arr;
   }

   public static int[] stringToInt(String in) {
      String[] strings = in.split(" ");
      int len = strings.length;
      int[] arr = new int[len];
      for (int i = 0; i < len; i++)
         arr[i] = Integer.valueOf(strings[i]);
      return arr;
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

   public static BigInteger combinations(int int0, int int1) {
      if (int1 > int0) {
         throw new IllegalArgumentException("Right side is larger than left side");
      }
      if (int1 == 0) {
         return BigInteger.ONE;
      }
      BigInteger temp = BigInteger.ONE;
      for (int i = int0; i > int1; i--) {
         temp = temp.multiply(BigInteger.valueOf(i));
      }
      BigInteger div = BigInteger.ONE;
      for (int i = 1; i <= int0 - int1; i++) {
         div = div.multiply(BigInteger.valueOf(i));
      }
      return temp.divide(div);
   }

   public static int digitSum(BigInteger n) {
      char[] digits = n.toString().toCharArray();
      int sum = 0;
      for (int i = 0; i < digits.length; i++) {
         sum += digits[i] - '0';
      }
      return sum;
   }

   public static BigInteger reverseNumber(BigInteger number) {
      BigInteger reversed = BigInteger.ZERO;
      BigInteger k = number;

      while (k.compareTo(BigInteger.ZERO) > 0) {
         reversed = reversed.multiply(BigInteger.TEN).add(k.mod(BigInteger.TEN));
         k = k.divide(BigInteger.TEN);
      }
      return reversed;
   }

   static public int reverseNumber(int number) {
      int reversed = 0;
      while (number > 0) {
         reversed = 10 * reversed + number % 10;
         number /= 10;
      }
      return reversed;
   }

   static public long reverseNumber(long number) {
      long reversed = 0;
      while (number > 0) {
         reversed = 10 * reversed + number % 10;
         number /= 10;
      }
      return reversed;
   }

   public static boolean isPseudoPrime(int n) {
      if (n <= 1)
         return false;
      if (n == 2)
         return true;
      if (n % 2 == 0)
         return false;
      if (n < 9)
         return true;
      if (n % 3 == 0)
         return false;
      if (n % 5 == 0)
         return false;

      int[] ar = new int[] {2, 3};
      for (int i = 0; i < ar.length; i++) {
         if (Witness(ar[i], n))
            return false;
      }
      return true;
   }


   private static boolean Witness(int a, int n) {
      int t = 0;
      int u = n - 1;
      while ((u & 1) == 0) {
         t++;
         u >>= 1;
      }

      long xi1 = ModularExp(a, u, n);
      long xi2;

      for (int i = 0; i < t; i++) {
         xi2 = xi1 * xi1 % n;
         if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1)))
            return true;
         xi1 = xi2;
      }
      if (xi1 != 1)
         return true;
      return false;
   }


   private static long ModularExp(int a, int b, int n) {
      long d = 1;
      int k = 0;
      while ((b >> k) > 0)
         k++;

      for (int i = k - 1; i >= 0; i--) {
         d = d * d % n;
         if (((b >> i) & 1) > 0)
            d = d * a % n;
      }

      return d;
   }

   public static int[] EncryptDecrypt(int[] message, int[] key) {
      int messageLength = message.length;
      int[] newMessage = new int[message.length];
      int keyLength = key.length;
      for (int i = 0; i < messageLength; i++) {
         newMessage[i] = message[i] ^ key[i % keyLength];
      }
      return newMessage;
   }

   public static String[] fileToStringArray(String file) throws IOException {
      LineNumberReader lnr = new LineNumberReader(new FileReader(file));
      lnr.skip(Long.MAX_VALUE);
      int lines = lnr.getLineNumber();
      lnr.close();
      BufferedReader bc_br = new BufferedReader(new FileReader(file));
      String[] data = new String[lines];
      for (int i = 0; i < lines; i++)
         data[i] = bc_br.readLine();
      bc_br.close();
      return data;
   }

   public static BigInteger getNextFib(BigInteger f0, BigInteger f1) {
      return f0.add(f1);
   }

   public static void writeFile(String filename, String content, boolean append) {
      // Write to the file
      try {
         File file = new File(filename);
         if (!file.exists()) {
            file.createNewFile();
         }

         FileWriter fw = new FileWriter(file.getAbsoluteFile(), append);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(content);
         bw.close();

      } catch (IOException e) {
         e.getStackTrace();
      }
   }

   public static int selectKth(Integer[] in, int n) {
      List<Integer> list = Arrays.asList(in);
      return recurse(list, n - 1);
   }

   public static int quickselect(int[] G, int k) {
      return quickselect(G, 0, G.length - 1, k - 1);
   }

   private static int quickselect(int[] G, int first, int last, int k) {
      if (first <= last) {
         int pivot = partition(G, first, last);
         if (pivot == k)
            return G[k];
         if (pivot > k)
            return quickselect(G, first, pivot - 1, k);
         return quickselect(G, pivot + 1, last, k);
      }
      return Integer.MIN_VALUE;
   }

   private static int partition(int[] G, int first, int last) {
      int pivot = first + new Random().nextInt(last - first + 1);
      swap(G, last, pivot);
      for (int i = first; i < last; i++) {
         if (G[i] > G[last]) {
            swap(G, i, first);
            first++;
         }
      }
      swap(G, first, last);
      return first;
   }

   public static int recurse(List<Integer> in, int n) {
      if (in.size() == 1)
         return in.get(0);
      List<Integer> smaller = new ArrayList<Integer>();
      List<Integer> larger = new ArrayList<Integer>();
      for (int i : in)
         if (i > in.get(n))
            larger.add(i);
         else
            smaller.add(i);
      if (larger.isEmpty() && in.size() == smaller.size())
         return smaller.get(0);
      return smaller.size() > n ? recurse(smaller, n) : recurse(larger, n - smaller.size());
   }

   public static void swap(int[] G, int x, int y) {
      int tmp = G[x];
      G[x] = G[y];
      G[y] = tmp;
   }

   public static int binarySearch(int[] arr, int val) {
      int i = arr.length / 2;
      int right = 0;
      int left = arr.length;
      while (right <= left) {
         i = (left - right) / 2;
         if (val > arr[i])
            right = i + 1;
         else if (val < arr[i])
            left = i - 1;
         else
            return i;
      }
      return -1;
   }
}
