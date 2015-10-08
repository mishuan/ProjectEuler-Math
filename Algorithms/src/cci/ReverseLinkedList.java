package cci;

/**
 * Created by ilikecalculus on 2015-09-24.
 */

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
      curr.ptr1 = newNode;
      curr = newNode;
    }
  }

  public static void reverse() {
    Node newHead = new Node();
    Node next = list.head;
    while (next.ptr1 != null) {
      Node temp = next.ptr1;
      next.ptr1 = newHead;
      newHead = next;
      next = temp;
    }
    next.ptr1 = newHead;
    list.head.ptr1 = null;
    list.head = next;
  }

  public static void print() {
    Node curr = list.head;
    while (curr != null) {
      System.out.println(curr.value);
      curr = curr.ptr1;
    }
  }
}


