package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {
   static int N;
   public static final boolean TEST = true;

   public static void run(Scanner in) {
      N = in.nextInt();
      in.nextLine();
      for (int i = 0; i < N; i++)
         calculateAnagrams(in.nextLine().trim());
   }

   public static void calculateAnagrams(String in) {
      int length = in.length();
      HashMap<String, Integer> map = new HashMap<String, Integer>(length * length / 2);
      int counter = 0;
      for (int i = 0; i < length; i++) {
         for (int j = i; j < length; j++) {
            char[] c = in.substring(i, j + 1).toCharArray();
            Arrays.sort(c);
            String s = String.valueOf(c);
            if (map.containsKey(s)) {
               int v = map.get(s);
               counter += map.get(s);
               map.put(s, v + 1);
            } else {
               map.put(s, 1);
            }
         }
      }
      System.out.println(counter);
   }

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         run(new Scanner("1\nabba\n"));
         run(new Scanner("5\nifailuhkqq\nhucpoltgty\novarjsnrbf\npvmupwjjjf\niwwhrlkpek\n"));
      }
   }
}
