class TimeMap {
    private HashMap<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(entry);
    }

    public String get(String key, int timestamp) {


        if(!map.containsKey(key)){
            return "";
        }

        List<Entry> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        int minT = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if ( list.get(mid).timestamp <= timestamp){
                minT = Math.max(minT, mid);
                left = mid + 1;
            }
            else { 
                right = mid - 1;
            }
            
        }

        if(minT == -1){
            return "";
        }
        return list.get(minT).value;
    }
}

class Entry {
    int timestamp;
    String value;

    Entry(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}