package leetcode;

/**
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
  public static int[] findSingle(int[] arr){
    int[] res = new int[2];
    int xor = 0;
    for(int n : arr) xor^= n;
    int bigOne = Integer.highestOneBit(xor);
    for(int n: arr){
      if((n & bigOne) == 0) res[0] ^= n;
      else res[1] ^= n;
    }
    return res;
  }
}
