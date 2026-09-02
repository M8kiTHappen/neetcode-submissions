class Solution {
    public int trap(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (left < right){

            //int lbar = height[left];
            //int rbar = height[right];

            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                if(height[right] >= maxRight){
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }

            
        }
        return water;
    }
}

// For there to be water ther must be at least a width of 1 between bars
// If there is not a array spot to the left/right that is empty there cant be water
// We can find the most amount of water between the two biggest bars by calculating the width
// and subtracting water