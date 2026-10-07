class Solution {
    List<String> result = new ArrayList<>();
    int n;
    private void backtrack(int open, int close, StringBuilder sb){

        if(open == n && close == n){
            result.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            backtrack(open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        

        
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, sb);
        return result;
    }
}
