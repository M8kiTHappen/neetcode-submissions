class Solution {
    List<List<Integer>> result = new LinkedList<>();
    private int[] nums;

    private void backtrack(int start, List<Integer> path){

        result.add(new ArrayList<>(path));

        for(int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(i + 1, path);
            path.remove(path.size() - 1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<Integer> path = new ArrayList<>();
        backtrack(0, path);
        return result;
    }
}
