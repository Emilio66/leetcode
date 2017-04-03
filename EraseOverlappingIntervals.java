/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //Greedy (beats 84%)
    //1. sorting by end point
    //2. if overlapped, choose the shortest one, counter plus 1
    /*public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                int gap = a.end - b.end;
                return gap == 0 ? a.start - b.start : gap; 
            }
        });
        
        int start = intervals[intervals.length - 1].start;
        int cnt = 0;
        //watch out: i can == 0, start from the second small one
        for(int i = intervals.length - 2; i >= 0; i--){
            if(intervals[i].end > start){
                cnt ++;
                //Greedy: always choose the shortest one
                if(intervals[i].start > start){
                    start = intervals[i].start;
                }
            }else{
                start = intervals[i].start;
            }
        }
        
        return cnt;
    }*/
    
    //Greedy (beats 87%)
    //1. sorting by start point
    //2. if overlapped, choose the shortest one plus 1
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                int gap = a.start - b.start;
                return gap == 0 ? a.end - b.end : gap; 
            }
        });
        
        int end = intervals[0].end;
        int cnt = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < end){
                cnt ++;
                //Greedy: always choose the shortest one
                if(intervals[i].end < end){
                    end = intervals[i].end;
                }
            }else{
                end = intervals[i].end;
            }
        }
        
        return cnt;
    }
    
}
