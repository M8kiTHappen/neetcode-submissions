
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        int[] c_counts = new int[26];

        for(int i=0; i < s.length(); i++){
            c_counts[s.charAt(i) - 'a']--;
            c_counts[t.charAt(i) - 'a']++;

        }

        for(int count: c_counts){
            if(count != 0){
                return false;
            }
        }

        

        // HashMap<Character, Integer> counts = new HashMap<>();

        // for(char c : s.toCharArray()){
        //     counts.put(c, counts.getOrDefault(c, 0) + 1);
        // }

        // for(char c : t.toCharArray()){
        //     counts.put(c, counts.getOrDefault(c, 0) - 1);
        //     if(counts.get(c) < 0){
        //         return false;
        //     }
        // }

        // for(int count : counts.values()){
        //     if (count != 0){
        //         return false;
        //     }
        // }

        return true;



    }
}
