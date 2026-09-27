class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxfreq = Collections.max(map.values());

        int numTWMF = 0;

        for(int freq : map.values()){
            if(freq == maxfreq){
                numTWMF++;
            }
        }

        int val = (maxfreq - 1) * (n + 1) + numTWMF;

        return Math.max(val, tasks.length);

    }
}
