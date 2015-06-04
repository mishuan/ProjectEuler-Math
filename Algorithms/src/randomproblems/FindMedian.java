package randomproblems;

import java.util.Arrays;
import java.util.Random;

import utility.CommonMethods;

public class FindMedian {


   public static void main(String[] args) {
      String in0 = "2 5 3 7 6 4 8 1 9";
      int median = CommonMethods.selectKth(CommonMethods.stringToInteger(in0), 5);
      System.out.println(median);
      benchmark(10, 100000, 1000000);
   }

   public static void benchmark(int tests, int size, int bound) {
      Random rand = new Random(0x3243);
      long t0 = System.currentTimeMillis();
      for (int i = 0; i < tests; i++) {
         StringBuilder sb = new StringBuilder();
         for (int j = 0; j < size; j++)
            sb.append(rand.nextInt(bound)).append(' ');
         CommonMethods.selectKth(CommonMethods.stringToInteger(sb.toString()), size / 2);
         CommonMethods.quickselect(CommonMethods.stringToInt(sb.toString()), size / 2);
         Integer[] arr = CommonMethods.stringToInteger(sb.toString());
         Arrays.sort(arr);
      }
      System.out.println("Prevent caching");

      t0 = System.currentTimeMillis();
      for (int i = 0; i < tests; i++) {
         StringBuilder sb = new StringBuilder();
         for (int j = 0; j < size; j++)
            sb.append(rand.nextInt(bound)).append(' ');
         CommonMethods.quickselect(CommonMethods.stringToInt(sb.toString()), size / 2);
      }
      System.out.println("O(n) not mine : " + (System.currentTimeMillis() - t0));

      t0 = System.currentTimeMillis();
      for (int i = 0; i < tests; i++) {
         StringBuilder sb = new StringBuilder();
         for (int j = 0; j < size; j++)
            sb.append(rand.nextInt(bound)).append(' ');
         CommonMethods.selectKth(CommonMethods.stringToInteger(sb.toString()), size / 2);
      }
      System.out.println("O(n) mine : " + (System.currentTimeMillis() - t0));

      t0 = System.currentTimeMillis();
      for (int i = 0; i < tests; i++) {
         StringBuilder sb = new StringBuilder();
         for (int j = 0; j < size; j++)
            sb.append(rand.nextInt(bound)).append(' ');
         Integer[] arr = CommonMethods.stringToInteger(sb.toString());
         Arrays.sort(arr);
      }
      System.out.println("O(nlgn) : " + (System.currentTimeMillis() - t0));
   }
}
