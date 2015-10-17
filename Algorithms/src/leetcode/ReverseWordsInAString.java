package leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {
  public static String reverseWords(String s) {
    String[] str = s.split(" ");
    if (str.length == 0) return "";
    StringBuffer sb = new StringBuffer();
    for (int i = str.length - 1; i >= 0; i--) {
      if (str[i].length() == 0) continue;
      sb.append(str[i].trim()).append(' ');
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("   a   b "));
  }
}
