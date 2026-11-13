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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> maxRooms = new PriorityQueue<>();
        
        for(int i = 0; i < intervals.size(); i++){
            
            if((!maxRooms.isEmpty()) && maxRooms.peek() <= intervals.get(i).start){
                maxRooms.poll();
            }
            maxRooms.add(intervals.get(i).end);
        }

        return maxRooms.size();
    }
}
