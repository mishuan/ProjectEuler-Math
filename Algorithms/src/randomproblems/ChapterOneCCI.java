package randomproblems;

public class ChapterOneCCI {
  public static String Q1_6(String s) {
    char[] chars = s.toCharArray();
    char temp = chars[0];
    int counter = 1;
    StringBuilder cmp = new StringBuilder();
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == temp) {
        counter++;
      } else {
        cmp.append(temp).append(counter);
        counter = 1;
        temp = chars[i];
      }
    }
    cmp.append(temp).append(counter);
    if (cmp.length() < chars.length)
      return cmp.toString();
    else
      return s;
  }

  public static void main(String args[]) {
    System.out.println(Q1_6("aabcccccaaa"));
  }
}
