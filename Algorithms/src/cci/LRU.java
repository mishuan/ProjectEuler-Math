package cci;

import java.util.HashMap;

/**
 * LRU Cache
 */

class Cache {
  int size;
  public Node head;
  public Node tail;
  public HashMap<Integer, Node> map = new HashMap<>();

  public Cache(int n) {
    size = n;
  }

  public String getValue(int key) {
    Node item = map.get(key);
    if (head != item) {
      remove(item);
      insert(item);
    }
    return item.value.toString();
  }

  private void remove(Node n) {
    if (n == null) return;
    if (n.ptr1 != null) n.ptr1.ptr2 = n.ptr2;
    if (n.ptr2 != null) n.ptr2.ptr1 = n.ptr1;
    if (n == head) head = n.ptr2;
    if (n == tail) tail = n.ptr1;
  }

  private void insert(Node n) {
    if (head == null) {
      head = n;
      tail = n;
    } else {
      head.ptr1 = n;
      n.ptr2 = head;
      head = n;
    }
  }

  public void setKeyVal(int k, String v) {
    if (map.containsKey(k)) {
      remove(map.get(k));
      map.remove(k);
    }
    if (map.size() == size) remove(tail);
    Node n = new Node();
    n.value = v;
    insert(n);
    map.put(k, n);
  }
}

public class LRU {
  public static void main(String args[]) {

  }
}
