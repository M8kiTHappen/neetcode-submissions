class Solution {
    HashMap<Integer, List<Integer>> prereqMap = new HashMap<>();
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int a = arr[0];
            int b = arr[1];
            prereqMap.get(a).add(b);
        }

        for (int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int course){
        if(state[course] == 1){
            return false;
        }
        if(state[course] == 2){
            return true;
        }

        state[course] = 1;

        for(int prereq : prereqMap.get(course)){
            if(!dfs(prereq)){
                return false;
            }
        }

        state[course] = 2;
        return true;
    }
}
