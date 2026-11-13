class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    fresh += 1;
                }
                if (grid[row][col] == 2) {
                    rotten.add(new int[] {row, col});
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while (!rotten.isEmpty() && fresh > 0) {
            int size = rotten.size();
            for (int k = 0; k < size; k++) {
                int[] cell = rotten.poll();
                int r = cell[0];
                int c = cell[1];
                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[nr].length
                        || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    rotten.add(new int[] {nr, nc});
                    fresh--;
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
