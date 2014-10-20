package randomproblems;

import java.util.ArrayList;

public class RecursionProblems {
   // multiply recursively
   public static int multiplyRecurse(int m, int n) {
      if (n == 0)
         return 0;
      return m + multiplyRecurse(m, n - 1);
   }

   public static int multiply(int m, int n) {

      if (m > n)
         return multiplyRecurse(m, n);
      return multiplyRecurse(n, m);
   }

   // find permutations
   public static void findPermutations(char[] c, int i, int n) {
      if (i == n)
         System.out.println(String.valueOf(c));
      else {
         for (int j = i; j <= n; j++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            findPermutations(c, i + 1, n);
            c[j] = c[i];
            c[i] = temp;
         }
      }
   }

   public static ArrayList<String> getPermutations(char[] c, int i, int n) {
      ArrayList<String> permutations = new ArrayList<String>();
      if (i == n)
         permutations.add(String.valueOf(c));
      else {
         for (int j = i; j <= n; j++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            permutations.addAll(getPermutations(c, i + 1, n));
            c[j] = c[i];
            c[i] = temp;
         }
      }
      return permutations;
   }

   // find all upper/lower cases variation of a string
   public static void getUpperLowerCasePermutations(char[] c, String prefix, int n) {
      char temp = Character.toUpperCase(c[n - 1]);
      if (n == c.length) {

         System.out.println(prefix + temp);
         System.out.println(prefix + c[n - 1]);
      } else {
         getUpperLowerCasePermutations(c, prefix + temp, n + 1);
         getUpperLowerCasePermutations(c, prefix + c[n - 1], n + 1);
      }
   }

   // find all permutations of 1 2 3 that add up to n
   public static void findPointsPermutations(String combo, int curr, int n) {
      if (n == curr)
         System.out.println(combo);
      if (curr + 1 <= n) {
         findPointsPermutations(combo + 1 + " ", curr + 1, n);
      }
      if (curr + 2 <= n) {
         findPointsPermutations(combo + 2 + " ", curr + 2, n);
      }
      if (curr + 3 <= n) {
         findPointsPermutations(combo + 3 + " ", curr + 3, n);
      }
   }

   // find operand permutation without duplicates ie 3 -> 1+2, 1+1+1
   public static void findOperandPermutations(String s, int curr, int n, int max) {
      if (curr == n)
         System.out.println(s);
      while (true) {
         if (curr + max <= n)
            findOperandPermutations(s + max + " ", curr + max, n, max);
         else
            break;
         max++;
      }
   }

   // recursively check if number is palindrome
   public static boolean isPalindrome(String s) {
      int length = s.length();

      if (length < 2)
         return true;

      if (s.charAt(0) == s.charAt(length - 1))
         return isPalindrome(s.substring(1, length - 1));

      return false;
   }

   public static int[] seq;

   public static int fib(int n) {
      if (seq[n - 1] == 0)
         fib(n - 1);
      if (seq[n - 2] == 0)
         fib(n - 2);
      seq[n] = seq[n - 1] + seq[n - 2];
      return seq[n];
   }

   public static int nthFib(int n) {
      seq = new int[n + 1];
      seq[0] = 1;
      seq[1] = 1;
      return fib(n);
   }

   public static void main(String[] args) {
      // String s = "1234";
      // findPermutations(s.toCharArray(), 0, s.length() - 1);
      // ArrayList<String> stringList = getPermutations(s.toCharArray(), 0, s.length() - 1);
      // System.out.println(stringList);

      // System.out.println(multiply(2, 5));

      // s = "abc";
      // getUpperLowerCasePermutations(s.toLowerCase().toCharArray(), "", 1);

      findPointsPermutations("", 0, 5);
      System.out.println("NO DUPLICATES: ");
      findOperandPermutations("", 0, 5, 1);

      // System.out.println(isPalindrome("121"));
      // System.out.println(isPalindrome("123321"));
      // System.out.println(isPalindrome("12431"));
      // System.out.println(isPalindrome("122341"));

      // System.out.println(nthFib(10));
      // for (int i : seq)
      // System.out.print(i + " ");
   }
}
