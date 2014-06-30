package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * This class will be used to for testing and researching encryption techniques, and encrypted
 * matching. Each instance of this class will always contain ONE set of client/server matches.
 * 
 * @author Michael Yuan
 * 
 */
// TODO: add some error checking
public class RandomHexGenerator {

   // Original strings generated
   public String[] clientStrings;
   // Array of strings that contain SOME matches to hexStrings
   public String[] matchStrings;
   // at index i, if matchStrings[i] == -1, then hex at index i does not match
   // to anything in hexStrings. if at index i matchStrings[i] > -1, then
   // matchStrings[i] = hexStrings[matchStrings[i]]
   public int[] matchedIndex;
   // number of matched index for matchStrings and hexStrings
   public int numOfMatches;
   // size of each array
   public int clientArraySize;
   // size of matchStrings
   public int matchArraySize;
   // length of each string in the two arrays
   public int stringLength;

   /**
    * Constructor for constructing RandomHexGenerator
    * 
    * @param limit number of strings in the hexadecimal array being used for matching
    * @param matchLimit number of strings in the array being matched against
    * @param length length of every string
    * @param numOfMatches number of strings that should be matched between matchStrings and
    *        hexStrings
    * @throws Exception
    */
   public RandomHexGenerator(int limit, int matchLimit, int length, int numOfMatches) throws Exception {
      reconstruct(limit, matchLimit, length, numOfMatches);
   }

   /**
    * Method used to construct the random values and strings
    * 
    * @param limit number of strings in the hexadecimal array being used for matching
    * @param matchLimit number of strings in the array being matched against
    * @param length length of every string
    * @param numOfMatches number of strings that should be matched between matchStrings and
    *        hexStrings
    * @throws Exception
    */
   public void reconstruct(int limit, int matchLimit, int length, int numOfMatches) throws Exception {
      clientArraySize = limit;
      matchArraySize = matchLimit;
      stringLength = length;
      clientStrings = hexGenerator(limit, length);
      matchStrings = matchStrings(clientStrings, matchLimit, numOfMatches);
   }

   /**
    * Write the client strings to a specified file with specified delimiter
    * 
    * @param directory the directory where the strings are contained. follows the format:
    *        /some/absolute/path/myfile.ext
    * @param option select 0 or 1 for which array desired to be printed. 0 is client array, 1 is
    *        match array
    */
   public void writeArrayStrings(String directory, int option) throws IOException {
      int size;
      String[] array;
      if (option == 0) {
         size = clientArraySize;
         array = clientStrings;
      } else if (option == 1) {
         size = matchArraySize;
         array = matchStrings;
      } else {
         throw new IllegalArgumentException();
      }
      File file = new File(directory);
      BufferedWriter output = new BufferedWriter(new FileWriter(file));
      for (int i = 0; i < size; i++) {
         output.write(i + "," + array[i]);
         output.newLine();
      }
      output.close();
   }

   /**
    * Method used to randomly generate number of hex strings. This method is used private matching
    * 
    * @param limit Number of strings desired in the array
    * @param length Length of each string in the array
    * @return hexStrings the randomly generated array of strings
    * @throws Exception
    */
   public String[] hexGenerator(int limit, int length) throws Exception {
      if (limit <= 0 || length <= 0) {
         throw new IllegalArgumentException();
      }
      String[] hexStrings = new String[limit];
      Random rand = new Random();
      for (int i = 0; i < limit; i++) {
         StringBuffer sb = new StringBuffer();
         while (sb.length() < length) {
            sb.append(Integer.toHexString(rand.nextInt()));
         }
         hexStrings[i] = sb.toString().substring(0, length);
      }
      return hexStrings;
   }

   /**
    * Method used to randomly generated an array with some matches to hexStrings array. Note the
    * desired matches is the optimal number of matches. In reality the number of matches can be
    * smaller if the random generator generates the same number more than once (number of matches
    * will follow a normal distribution)
    * 
    * @param stringArray the array being matched with
    * @param desiredMatches number of matches desired to the original array
    * @return a random array containing certain number of entries matching original array
    * @throws Exception
    */
   private String[] matchStrings(String[] stringArray, int limit, int desiredMatches) throws Exception {
      if (limit <= 0) {
         throw new IllegalArgumentException();
      }
      if (desiredMatches == 0) {
         numOfMatches = clientArraySize;
         matchArraySize = clientArraySize;
         matchedIndex = new int[clientArraySize];
         for (int i = 0; i < clientArraySize; i++) {
            matchedIndex[i] = i;
         }
         return stringArray;
      }
      int matches = 0;
      int index[] = new int[limit];
      Arrays.fill(index, -1);
      String[] matchedArray = hexGenerator(limit, stringLength);
      Random rand = new Random();
      for (int i = 0; i < desiredMatches; i++) {
         int temp = rand.nextInt(limit);
         if (index[temp] == -1) {
            int hexIndex = rand.nextInt(stringArray.length);
            matchedArray[temp] = stringArray[hexIndex];
            index[temp] = hexIndex;
            matches++;
         }
      }
      numOfMatches = matches;
      matchedIndex = index;
      return matchedArray;
   }
}
