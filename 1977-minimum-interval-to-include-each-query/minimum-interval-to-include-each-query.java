class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[][] queriesWithIndex = new int[queries.length][2];
        int[] result = new int[queries.length];
        for(int i = 0; i< queries.length; i++){
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }
        int j = 0;
        Arrays.sort(queriesWithIndex, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-a[0]-(b[1]-b[0])));
        for(int i = 0;i< queries.length; i++){
            int query = queriesWithIndex[i][0];
            int queryIndex = queriesWithIndex[i][1];

            while(j< intervals.length && intervals[j][0] <= query){
                if (query <= intervals[j][1])
                pq.add(intervals[j]);
                j++;
            }

            while(!pq.isEmpty() && pq.peek()[1]<query){
                pq.poll();
            } 
            result[queryIndex] = pq.isEmpty() ? -1 : pq.peek()[1]-pq.peek()[0]+1;
        }
        return result;
    }
}