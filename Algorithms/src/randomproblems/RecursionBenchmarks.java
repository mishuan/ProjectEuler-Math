package randomproblems;

import java.util.ArrayList;
import java.util.LinkedList;

public class RecursionBenchmarks {
   static int counter = 0;
   static char[] charArray = {'a', 'b'};
   static int length = 20;
   static ArrayList<String> globalList = new ArrayList<String>();

   // recursion 1
   public static ArrayList<String> arrayListPermutations(char[] cArray, String prefix, int sLength) {
      ArrayList<String> set = new ArrayList<String>();
      if (sLength == 1) {
         for (char c : cArray)
            set.add(prefix + c);
      } else {
         for (char c : cArray) {
            set.addAll(arrayListPermutations(cArray, prefix + c, sLength - 1));
         }
      }
      return set;
   }

   public static ArrayList<String> permute(char[] cArray, int sLength) {
      return arrayListPermutations(cArray, "", sLength);
   }

   // recursion 2
   public static void print(char[] cArray, String prefix, int sLength) {

      if (sLength == 1) {
         for (int i = 0; i < cArray.length; i++)
            counter++;
      } else {
         for (char c : cArray) {
            print(cArray, prefix + c, sLength - 1);
         }
      }
   }

   public static void printPermutations(char[] cArray, int sLength) {
      print(cArray, "", sLength);
   }

   // recursion 3
   public static void pointerAdd(char[] cArray, String prefix, int sLength, ArrayList<String> arrayList) {

      if (sLength == 1) {
         for (char c : cArray)
            arrayList.add(prefix + c);
      } else {
         for (char c : cArray) {
            pointerAdd(cArray, prefix + c, sLength - 1, arrayList);
         }
      }
   }

   public static void pointerPermutations(char[] cArray, int sLength, ArrayList<String> arrayList) {
      pointerAdd(cArray, "", sLength, arrayList);
   }

   // recursion 4
   public static void globalAdd(char[] cArray, String prefix, int sLength) {

      if (sLength == 1) {
         for (char c : cArray)
            globalList.add(prefix + c);
      } else {
         for (char c : cArray) {
            globalAdd(cArray, prefix + c, sLength - 1);
         }
      }
   }

   public static void globalPermutations(char[] cArray, int sLength) {
      globalAdd(cArray, "", sLength);
   }

   // no recursion
   public static ArrayList<String> getPermutations(char[] cArray, int sLength) {
      LinkedList<String> variations = new LinkedList<String>();
      for (char c : cArray)
         variations.add(String.valueOf(c));
      for (int i = 1; i < sLength; i++) {
         LinkedList<String> newList = new LinkedList<String>();
         while (!variations.isEmpty()) {
            String curr = variations.poll();
            for (char c : cArray)
               newList.add(curr + c);
         }
         variations.addAll(newList);
      }
      ArrayList<String> returnList = new ArrayList<String>();
      returnList.addAll(variations);
      return returnList;
   }

   public static void main(String[] args) {
      long init = System.currentTimeMillis();
      System.out.println(permute(charArray, length).size());
      System.out.println("ArrayList Return took: " + (System.currentTimeMillis() - init));

      init = System.currentTimeMillis();
      printPermutations(charArray, length);
      System.out.println(counter);
      System.out.println("No return took: " + (System.currentTimeMillis() - init));

      init = System.currentTimeMillis();
      ArrayList<String> variations = new ArrayList<String>();
      pointerPermutations(charArray, length, variations);
      System.out.println(variations.size());
      System.out.println("Passing in ArrayList took: " + (System.currentTimeMillis() - init));

      init = System.currentTimeMillis();
      globalPermutations(charArray, length);
      System.out.println(globalList.size());
      System.out.println("Adding to global ArrayList took: " + (System.currentTimeMillis() - init));
      globalList.clear();

      init = System.currentTimeMillis();
      globalList = getPermutations(charArray, length);
      System.out.println(globalList.size());
      System.out.println("No recursion took: " + (System.currentTimeMillis() - init));
      globalList.clear();
   }
}
