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
   public static void getPermutations(char[] c, String prefix, int n) {
      char temp = Character.toUpperCase(c[n - 1]);
      if (n == c.length) {

         System.out.println(prefix + temp);
         System.out.println(prefix + c[n - 1]);
      } else {
         getPermutations(c, prefix + temp, n + 1);
         getPermutations(c, prefix + c[n - 1], n + 1);
      }
   }

   public static void main(String[] args) {
      String s = "1234";
      findPermutations(s.toCharArray(), 0, s.length() - 1);
      ArrayList<String> stringList = getPermutations(s.toCharArray(), 0, s.length() - 1);
      System.out.println(stringList);

      System.out.println(multiply(2, 5));

      s = "abc";
      getPermutations(s.toLowerCase().toCharArray(), "", 1);
   }
}
