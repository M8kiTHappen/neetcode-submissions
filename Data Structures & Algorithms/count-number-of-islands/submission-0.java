class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == '1'){
                    count += 1;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
