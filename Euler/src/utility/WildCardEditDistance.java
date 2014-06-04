package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is intended to find variations of a string following the edit distance algorithm. The
 * variation could be used for encrypted fuzzy matching
 * 
 * @author Michael Yuan
 * 
 */
// TODO: Add encryption/decryption methods
public class WildCardEditDistance {

   /**
    * Default empty constructor
    */
   public WildCardEditDistance() {

   }

   /**
    * Method used to generate the derivatives of a string given a defined number of wild cards
    * 
    * @param string the string desired turn into fuzzy wild card string
    * @param wildcards the desired wild cards
    * @return an array of variations given the specified parameters
    */
   public List<String> getVariations(String string, int wildcards) {
      if (wildcards > string.length()) {
         throw new IllegalArgumentException("Wild card input is larger than string length");
      }
      List<String> variations = new ArrayList<String>();
      variations.add(string);
      List<String> previous = variations;
      for (int n = 1; n <= wildcards; n++) {
         List<String> current = new ArrayList<String>();
         for (String object : previous) {
            StringBuilder sb = new StringBuilder(object);
            sb.insert(0, "*");
            current.add(sb.toString());
            char[] charArray = object.toCharArray();
            for (int i = 0; i < object.length(); i++) {
               if (charArray[i] != '*') {
                  sb = new StringBuilder(object);
                  sb.replace(i, i + 1, "*");
                  current.add(sb.toString());
                  sb = new StringBuilder(object);
                  sb.insert(i + 1, "*");
                  current.add(sb.toString());
               }
            }
         }
         variations.addAll(current);
         previous = current;
      }
      return variations;
   }
}
