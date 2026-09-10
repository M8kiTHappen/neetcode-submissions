class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows * cols - 1;
        //int eIndex = matrix[end / rows][end % cols];
        int left = 0;
        while(left <= right){

            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int midV = matrix[row][col];

            if(midV == target){
                return true;
            }
            else if (midV < target){
                left = mid + 1;
            }
            else{
                
                right = mid - 1;
            }
        }

        return false;

    }
}
