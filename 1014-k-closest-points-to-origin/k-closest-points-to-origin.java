class Solution {
     public int[][] kClosest(int[][] points, int k) {
        int[] origin = {0,0};
        PriorityQueue<int[]> queue = new PriorityQueue<>( (p1,p2) -> {
            double p1Val = getDistance(origin, p1);
            double p2Val = getDistance(origin,p2);
            if(p1Val < p2Val) return -1;
            else return 1;
        });
        for(int[] p : points){
            queue.offer(p);
        }
        int[][] ans = new int[k][];
        for(int i = 0; i<k;i++){
            ans[i] = queue.poll();
        }
        return ans;
    }

    public double getDistance(int[] p1, int[] p2){
        return Math.sqrt(Math.pow(Math.abs(p1[0]-p2[0]),2) + Math.pow(Math.abs(p1[1]-p2[1]),2));
    }
}