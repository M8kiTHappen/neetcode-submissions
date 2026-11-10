class Solution {
    int islandArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                dfs(grid, row, col);
                maxIsland = Math.max(maxIsland, islandArea);
                islandArea = 0;
            }
        }

        return maxIsland;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;

        islandArea += 1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        return 0;

    }
}
