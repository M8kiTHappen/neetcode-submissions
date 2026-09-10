class Solution {
    public int search(int[] nums, int target) {
        
        
        int left = 0;
        int right = nums.length - 1;

        while ( left <= right){

            int middlePos =  left + (right - left ) / 2;
            int middleNum = nums[middlePos];

            if ( target == middleNum){
                return middlePos;
            }
            else if ( middleNum < target){
                
                left = middlePos + 1;
            }
            else{
                right = middlePos - 1;
            }
        }

        return -1;
        

    }

    
}
