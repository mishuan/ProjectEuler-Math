package leetcode;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {
  public static int reverseBits(int n){
    long res = 0;
    for(int i = 0; i < 31; i++){
      int curr = n & 1;
      n = n >> 1;
      res |= curr;
      res = res << 1;
    }
    res |= (n&1);
    return (int)res;

  }
  public static void main(String[] args){
    System.out.println(Integer.toBinaryString(43261596));
    System.out.println(Integer.toBinaryString(reverseBits(43261596)));
  }
}
