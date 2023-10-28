class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for(int[] a : prerequisites)
            indegree[a[0]]++;
        // course without deps
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int coursewithoutdeps = q.size();
        while(!q.isEmpty()){
            int c = q.remove();
            for(int[] a : prerequisites){
                if(a[1] == c){
                    indegree[a[0]]--;
                    if(indegree[a[0]] == 0){
                        coursewithoutdeps++;
                        q.offer(a[0]);
                    }
                }
            }
        }
        return coursewithoutdeps == numCourses;
    }
}