class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] result = new int[nums.length - k +1];

        int resultIndex = 0;

        for(int right = 0; right < nums.length; right++){

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.pollLast();
            }

            deque.offerLast(right);

            if(deque.peekFirst() <= right - k){
                deque.pollFirst();
            }

            if(right >= k - 1){
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
