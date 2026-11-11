class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if (grid[row][col] == 0){
                    int[] arr = {row, col};
                    q.add(arr);
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] d : dirs){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[nr].length || grid[nr][nc] != Integer.MAX_VALUE){
                continue;
                }

                grid[nr][nc] = grid[r][c] + 1;
                q.add(new int[]{nr, nc});
            }


        }
    }
}
