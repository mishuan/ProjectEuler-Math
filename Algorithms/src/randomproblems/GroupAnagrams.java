package randomproblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] arr) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : arr) {
      String hash = getHash(s);
      if (map.containsKey(hash)) map.get(hash).add(s);
      else {
        List<String> l = new LinkedList<>();
        l.add(s);
        map.put(hash, l);
      }
    }
    List<List<String>> ret = new LinkedList<>();
    for (List<String> list : map.values()) ret.add(list);
    return ret;
  }

  public String getHash(String s) {
    int[] occurances = new int[26];
    for (char c : s.toCharArray()) occurances[c - 'a']++;
    StringBuffer sb = new StringBuffer();
    for (int i : occurances) sb.append(i).append(' ');
    return sb.toString();
  }
}
