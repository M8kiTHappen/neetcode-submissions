class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int[] nums; 
    int target;
    int sum = 0;
    private void backtrack(int start, int remaining, List<Integer> path){
        if(remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(i, remaining - nums[i], path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        List<Integer> path = new ArrayList<>();
        backtrack(0, target, path);
        return result;
    }
}
