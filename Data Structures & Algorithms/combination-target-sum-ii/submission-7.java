class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int[] candidates;
    private void backtrack(int start, int remaining, List<Integer> path) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // if (remaining < 0) {
        //     return;
        // }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > remaining) {
                break;
            }
            path.add(candidates[i]);
            backtrack(i + 1, remaining - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        List<Integer> path = new ArrayList<>();
        backtrack(0, target, path);
        return result;
    }
}
