class Solution {
    List<List<String>> result = new LinkedList<>();
    String s;
    int left;
    int right;
    private void backtrack(int start, List<String> path) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i)) {
                path.add(s.substring(start, i + 1));
                backtrack(i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        this.s = s;
        List<String> path = new ArrayList<>();
        backtrack(0, path);
        return result;
    }

    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
