class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length() || t.isEmpty()){
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;

        int left = 0;
        int bestLength = Integer.MAX_VALUE;
        int bestLeft = 0;

        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if ( need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()){
                formed++;
            }

            while (formed == required){
                if (right - left + 1 < bestLength){
                    bestLength = right - left + 1;
                    bestLeft = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    formed--;
                }

                left++;
            }
        }

        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestLeft, bestLength + bestLeft);
        

        
    }
}
