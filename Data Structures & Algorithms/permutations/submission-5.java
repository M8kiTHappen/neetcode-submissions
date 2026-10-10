class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int[] nums;
    boolean[] used;
    private void backtrack(List<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrack(path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.used = new boolean[nums.length];
        this.nums = nums;
        List<Integer> path = new ArrayList<>();
        backtrack(path);
        return result;

    }
}
