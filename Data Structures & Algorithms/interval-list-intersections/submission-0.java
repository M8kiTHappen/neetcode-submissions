class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervals = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if(start <= end){
                int[] current = {start, end};
                intervals.add(current);
                
            }

            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }

        int[][] results = intervals.toArray(new int[intervals.size()][]);

        return results;
    }
}