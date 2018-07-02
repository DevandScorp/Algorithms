package Arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class Overlapping_Intervals {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return 1;
                return 0;
            }
        });
        ArrayList<Interval> result = new ArrayList<>();
        Interval interval = new Interval(intervals.get(0).start, intervals.get(0).end);
        int i = 1;
        for (;i < intervals.size(); ++i) {
            if (intervals.get(i).start <= interval.end) {
                interval.end = Math.max(interval.end,intervals.get(i).end);
            } else {
                result.add(interval);
                interval.start = intervals.get(i).start;
                interval.end = intervals.get(i).end;
            }
        }
        result.add(interval);
        return result;
    }
    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(4, 100));
//        intervals.add(new Interval(48, 94));
//        intervals.add(new Interval(16, 21));
//        intervals.add(new Interval(58, 71));// (36, 53), (49, 68), (18, 42), (37, 90), (68, 75), (6, 57), (25, 78), (58, 79), (18, 29), (69, 94)
        ArrayList<Interval> result = new Overlapping_Intervals().merge(intervals);
        for(Interval interval:result){
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
