package randomproblems;

import java.util.ArrayList;

public class KmpAlgorithm {
   static public int[] constructPartialMatchTable(String pattern) {
      int[] table = new int[pattern.length()];
      char[] p = pattern.toCharArray();
      for (int i = 1; i < pattern.length(); i++) {
         int previous = table[i - 1];
         table[i] = p[i] == p[previous] ? previous + 1 : 0;
      }
      return table;
   }

   static public ArrayList<Integer> kmpFind(String text, String pattern) {
      int[] matchTable = constructPartialMatchTable(pattern);
      ArrayList<Integer> matches = new ArrayList<Integer>();
      char[] p = pattern.toCharArray();
      char[] t = text.toCharArray();

      int partialLength = 0;
      int i = 0;
      while (i < text.length()) {
         if (t[i] == p[partialLength]) {
            partialLength++;
            i++;

            if (partialLength == pattern.length()) {
               matches.add(i - partialLength);
               partialLength = matchTable[partialLength - 1];
            }
         } else {
            if(partialLength != 0)
               partialLength = matchTable[partialLength-1];
            else
               i++;
         }
      }
      System.out.println();
      return matches;
   }

   public static void main(String[] args) {
      for (int i : constructPartialMatchTable("aaba"))
         System.out.print(i + " ");

      System.out.println();
      System.out.print("A A B A A C A A D A A B A A A B A A");
      for (Integer i : kmpFind("AABAACAADAABAAABAA", "AABA"))
         System.out.print(i + " ");
   }
}
