class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ints = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            int currentEnd = current[1];
            int currentStart = current[0];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(currentEnd >= nextStart){
                int newEnd = Math.max(currentEnd, nextEnd);
                current[0] = currentStart;
                current[1] = newEnd;
            } else{
                ints.add(current);
                current = intervals[i];
            }

        }

        ints.add(current);

        int[][] array2D = ints.toArray(new int[ints.size()][]);

        return array2D;

    }
}
