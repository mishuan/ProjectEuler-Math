package cci;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ilikecalculus on 2015-10-15.
 */
public class Test {
  public static void  main(String[] args){
    String[] strs= {};
    System.out.println(strs.length);
  }
  public List<Integer> findKth(int k, Node<Integer> n) {
    List<Integer> list = new ArrayList<>();
    recurse(n, list, k);
    return list;
  }
  public void recurse(Node<Integer> n, List<Integer> list, int k) {
    if (n.ptr2 != null) recurse(n.ptr2, list, k);
    if (list.size() < k) list.add(n.value);
    if (n.ptr1 != null) recurse(n.ptr1, list, k);
  }
}
