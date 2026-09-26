class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size() > 1){
            int sum = 0;
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x != y){
                sum = Math.max(x, y) - Math.min(x, y);
            }

            maxHeap.add(sum);
        }

        return maxHeap.peek();
    }
}
