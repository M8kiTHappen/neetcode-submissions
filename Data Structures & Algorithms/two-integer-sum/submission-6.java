class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //Set<Integer> numSet = new HashSet<>();

        // for(int i = 0; i < nums.length; i++){
        //     for(int j = i + 1; j < nums.length; j++){
        //         if (nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }

        // return nums;

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }

        return nums;

    }
}
