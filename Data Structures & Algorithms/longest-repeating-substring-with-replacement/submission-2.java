class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        int[] count = new int[26];
        int left = 0;
        int maxRep = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'A']++;
            maxRep = Math.max(maxRep, count[s.charAt(right) - 'A']);
            
            while((right - left + 1) - maxRep > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

        

        
    }
}
