package randomproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Assn1AnimoAcidFrequency {
   static HashMap<Character, Integer> aaCountMap;
   static final char[] aa = {'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W',
         'Y'};
   static int aaCountTotal = 0;

   public static void main(String[] args) throws IOException {
      aaCountMap = new HashMap<Character, Integer>(20);
      createAAMap();
      updateMapFromFile(args[0]);
      if (aaCountTotal > 0) {
         printAAFreq();
      }
      System.out.println("Total: " + aaCountTotal);
   }

   public static void createAAMap() {
      for (char c : aa)
         aaCountMap.put(c, 0);
   }

   public static void updateMapFromFile(String file) throws IOException {
      BufferedReader bc_br = new BufferedReader(new FileReader(file));
      String line;
      while ((line = bc_br.readLine()) != null) {
         line = line.toUpperCase();
         if (line.length() <= 0)
            continue;
         char firstChar = line.charAt(0);
         if (firstChar >= 'A' && firstChar <= 'Z') {
            for (char c : line.toCharArray()) {
               if (aaCountMap.containsKey(c)) {
                  aaCountMap.put(c, aaCountMap.get(c) + 1);
                  aaCountTotal++;
               } else {
                  System.err.println("Invalid input: " + Character.toString(c));
               }
            }
         }
      }
      bc_br.close();
   }

   public static void printAAFreq() {
      for (char c : aa) {
         int aaCountCur = aaCountMap.get(c);
         if (aaCountCur > 0) {
            double aaFreq = aaCountCur / (double) aaCountTotal;
            System.out.println(Character.toString(c) + " " + String.format("%.3g", aaFreq));
         }
      }
   }
}
