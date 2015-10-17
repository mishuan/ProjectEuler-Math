package cci;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ilikecalculus on 2015-10-15.
 */
public class Test {
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

  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> ret = new LinkedList<>();
    if (intervals.size() == 0) return ret;
    Collections.sort(intervals, new IntervalComparator());
    ret.add(intervals.get(0));
    int retIdx = 0;
    for (int i = 1; i < intervals.size(); i++) {
      Interval curr = intervals.get(i);
      Interval prev = ret.get(retIdx);
      if (prev.start <= curr.start && prev.end >= curr.start) {
        prev.start = Math.min(curr.start, prev.start);
        prev.end = Math.max(curr.end, prev.end);
      } else {
        ret.add(curr);
        retIdx++;
      }
    }
    return ret;
  }
  class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
  }
  public class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
