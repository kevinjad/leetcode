class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, 0, visited);
        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int i, boolean[] visited){
        for(int e : rooms.get(i)){
            if(visited[e]) continue;
            visited[e] = true;
            dfs(rooms, e, visited);
        }
    }
}