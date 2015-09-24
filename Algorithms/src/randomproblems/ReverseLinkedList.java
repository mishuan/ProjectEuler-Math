package randomproblems;

/**
 * Created by ilikecalculus on 2015-09-24.
 */

class Node {
  Node next;
  int value;

  public String print() {
    return next != null ? value + " " + next.print() : String.valueOf(value);
  }
}

class LinkedList {
  Node head;
}

public class ReverseLinkedList {
  static LinkedList list;

  public static void main(String[] args) {
    createList();
    reverse();
    System.out.println(list.head.print());
  }

  public static void createList() {
    Node head = new Node();
    head.value = 0;
    list = new LinkedList();
    list.head = head;
    Node curr = head;
    for (int i = 1; i < 10; i++) {
      Node newNode = new Node();
      newNode.value = i;
      curr.next = newNode;
      curr = newNode;
    }
  }

  public static void reverse() {
    Node last = list.head;
    Node newHead = new Node();
    Node next = list.head;
    while (next.next != null) {
      Node temp = next.next;
      next.next = newHead;
      newHead = next;
      next = temp;
    }
    next.next = newHead;
    last.next = null;
    list.head = next;
  }

  public static void print() {
    Node curr = list.head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
  }
}


