package hackerrank;


public final class LookAndSay {
   public static void main(String[] args) throws Exception {
      System.out.println(nthLookSay(15));
   }

   public static String nthLookSay(int n) {
      String returnString = "1";
      for (int i = 0; i < n; i++) {
         char[] charArray = returnString.toCharArray();
         returnString = "";
         char prev = charArray[0];
         int counter = 0;
         for (char c : charArray) {
            if (c != prev) {
               returnString = returnString + counter + prev;
               prev = c;
               counter = 0;
            }
            counter++;
         }
         returnString = returnString + counter + prev;
      }
      return returnString;
   }
}
