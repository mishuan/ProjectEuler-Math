package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeInterval {
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
