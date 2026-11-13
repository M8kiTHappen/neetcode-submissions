/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        

        for(Interval inter : intervals){
            starts.add(inter.start);
            ends.add(inter.end);
        }

        for(int i = 1; i < ends.size(); i++){
            if(starts.get(i) < ends.get(i - 1)){
                return false;
            }
        }

        return true;
    }
}
