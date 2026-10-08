class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(dfs(i, j, 0, board, word)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int index, char[][] board, String word){

        if(index == word.length()){
            return true;
        }

        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(row + 1, col, index + 1, board, word) || dfs(row - 1, col, index + 1, board, word) || dfs(row, col + 1, index + 1, board, word) || dfs(row, col - 1, index + 1, board, word);

        board[row][col] = temp;

        return found;


    }
}
