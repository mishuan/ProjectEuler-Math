package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-pairs
 */
public class SherlockAndPairs {
  public static final boolean TEST = false;
  public static int T;
  public static int len;

  public static void run(Scanner in) {
    T = in.nextInt();
    for (int i = 0; i < T; i++) {
      in.nextLine();
      len = in.nextInt();
      in.nextLine();
      int[] array = new int[len];
      for (int k = 0; k < len; k++)
        array[k] = in.nextInt();
      sherlockAndPairs(array);
    }
  }

  public static void sherlockAndPairs2(int[] array) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : array) {
      if (map.containsKey(n))
        map.put(n, map.get(n) + 1);
      else
        map.put(n, 1);
    }
    int total = 0;
    for (int value : map.values())
      total += value * (value - 1);
    System.out.println(total);
  }

  public static void sherlockAndPairs(int[] array) {
    Arrays.sort(array);
    int k = array[0];
    long count = 1;
    long total = 0;
    for (int i = 1; i < array.length; i++) {
      if (k == array[i])
        count++;
      else {
        total += count * (count - 1);
        k = array[i];
        count = 1;
      }
    }
    total += count * (count - 1);
    System.out.println(total);
  }

  public static void main(String[] args) {
    if (!TEST) {
      Scanner in = new Scanner(System.in);
      run(in);
      in.close();
    } else {
    }
  }
}
