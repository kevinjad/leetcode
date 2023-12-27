class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<PointDistance> minHeap = new PriorityQueue<PointDistance>(Comparator.comparingInt(o -> o.distance));
        minHeap.add(new PointDistance(0,0));
        int count = 0;
        while(!minHeap.isEmpty()){
            PointDistance p = minHeap.remove();
            if(visited.contains(p.node)) continue;
            count += p.distance;
            visited.add(p.node);
            if(visited.size() == points.length) return count;
            //add all connected nodes to minHeap
            for(int i = 0;i<points.length;i++) {
                if(i == p.node || visited.contains(i)) continue;
                minHeap.add(new PointDistance(findDist(points, p.node, i), i));
            }
        }
        return count;
    }

    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

    private class PointDistance {
        int distance;
        int node;

        PointDistance(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
}