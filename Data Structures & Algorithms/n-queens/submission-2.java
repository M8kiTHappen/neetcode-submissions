class Solution {
    int n;
    List<List<String>> result = new LinkedList<>();
    Set<Integer> columns = new HashSet<>();
    Set<Integer> diagonalRight = new HashSet<>();
    Set<Integer> diagonalLeft = new HashSet<>();
    private void backtrack(int row, List<Integer> path){
        if(row == n){
            List<String> board = new ArrayList<>();
            for (int queenCol : path) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[queenCol] = 'Q';
                board.add(new String(chars));
            }
            result.add(board);
            return;
        }

        for(int col = 0; col < n; col++){
            if(columns.contains(col) || diagonalRight.contains(row - col) || diagonalLeft.contains(row + col)){
                continue;
            }

            columns.add(col);
            diagonalRight.add(row - col);
            diagonalLeft.add(row + col);
            path.add(col);
            backtrack(row + 1, path);
            path.remove(path.size() - 1);
            columns.remove(col);
            diagonalRight.remove(row - col);
            diagonalLeft.remove(row + col);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        backtrack(0, new ArrayList<>());
        return result;
    }
}
