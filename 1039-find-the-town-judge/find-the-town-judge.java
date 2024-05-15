class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] visited = new boolean[n];
        int[] trusted = new int[n];
        Arrays.fill(trusted, 0);
        for(int[] t : trust){
            visited[t[0]-1] = true;
            trusted[t[1]-1]++;
        }
        for(int i = 0;i<n;i++){
            if(!visited[i] && trusted[i]==n-1) return i+1;
        }
        return -1;
    }
}