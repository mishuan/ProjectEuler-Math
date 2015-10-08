package cci;

/**
 * Created by ilikecalculus on 2015-10-08.
 */
public class Node <T> {
  Node ptr1;
  Node ptr2;
  T value;

  public String print() {
    return ptr1 != null ? value + " " + ptr1.print() : String.valueOf(value);
  }
}
