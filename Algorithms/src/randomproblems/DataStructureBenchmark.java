package randomproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;


public class DataStructureBenchmark {

   static public void testArray(int limit) {
      int[] test = new int[limit];
      Random rand = new Random();
      long init = System.currentTimeMillis();
      for (int i = 0; i < limit; i++) {
         int randomNum = rand.nextInt(limit + 1);
         test[i] = randomNum;
      }
      Arrays.sort(test);
      StringBuilder sb = new StringBuilder();
      for (int i : test)
         sb.append(i);
      System.out.println("Array took: " + (System.currentTimeMillis() - init));
   }

   static public void testTreeSet(int limit) {
      Random rand = new Random();
      long init = System.currentTimeMillis();
      TreeSet<Integer> test = new TreeSet<Integer>();
      for (int i = 0; i < limit; i++) {
         int randomNum = rand.nextInt(limit + 1);
         test.add(randomNum);
      }
      StringBuilder sb = new StringBuilder();
      for (int i : test)
         sb.append(i);
      System.out.println("Tree Set took: " + (System.currentTimeMillis() - init));
   }
   static public void testArrayList(int limit) {
      ArrayList<Integer> test = new ArrayList<Integer>();
      Random rand = new Random();
      long init = System.currentTimeMillis();
      for (int i = 0; i < limit; i++) {
         int randomNum = rand.nextInt(limit + 1);
         test.add(randomNum);
      }
      Collections.sort(test);
      StringBuilder sb = new StringBuilder();
      for (int i : test)
         sb.append(i);
      System.out.println("Array list took: " + (System.currentTimeMillis() - init));
   }
   public static void main(String[] args) {
      testArray(1000);
      testTreeSet(100000);
      testArrayList(1000);
   }
}
