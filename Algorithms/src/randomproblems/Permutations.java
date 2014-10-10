package randomproblems;

import java.util.ArrayList;

public class Permutations {
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

   public static void main(String[] args) {
      String s = "1234";
      findPermutations(s.toCharArray(), 0, s.length() - 1);
      ArrayList<String> stringList = getPermutations(s.toCharArray(), 0, s.length() - 1);
      System.out.println(stringList);
   }
}
