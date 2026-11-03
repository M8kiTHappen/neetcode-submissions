class Solution {
    List<String> result = new ArrayList<>();
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String digits;
    private void backtrack (int index, StringBuilder sb){
        
        if(index == digits.length()){
            String str = sb.toString();
            result.add(str);
            return;
        }
        char digit = digits.charAt(index);
        String options = letters[digit - '0'];

        for(char c : options.toCharArray()){
            sb.append(c);
            backtrack(index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() <= 0) { return new ArrayList<>(); }
        this.digits = digits;
        StringBuilder sb = new StringBuilder();
        backtrack(0, sb);
        return result;
        
    }
}
