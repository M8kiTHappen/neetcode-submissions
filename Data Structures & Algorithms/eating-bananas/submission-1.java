class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        
        int high = piles[0];

        for (int pile : piles) {
        high = Math.max(high, pile);
        }

        int minK = Integer.MAX_VALUE;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(valid(mid, piles, h)){
                minK = Math.min(mid, minK);
                high = mid - 1;
            }
            else{

                low = mid + 1;
            }


        }

        return minK;

    }

    private boolean valid(int mid, int[] piles, int h){

        int count = 0;
        for(int i = 0; i < piles.length; i++){
            count = count + ((mid + piles[i] - 1) / mid);
        }
        
        return count <= h;
    }
}
