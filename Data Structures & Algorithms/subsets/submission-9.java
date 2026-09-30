class Solution {
    List<List<Integer>> result = new LinkedList<>();
    private int[] nums;
    private void backtrack(int start, List<Integer> path){
        
        result.add(new ArrayList<>(path));
        for (int i = start; i < this.nums.length; i++){
            path.add(this.nums[i]);
            backtrack(i + 1, path);
            path.remove(path.size() - 1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> path = new LinkedList<>();
        backtrack(0, path);
        return result;
    }
}
