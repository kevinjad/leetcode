class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        for(i = 0;i<intervals.length;i++){
            if(intervals[i][1] >= newInterval[0]) break;
            result.add(intervals[i]);
        }
        //now merge
        for(;i<intervals.length;i++){
            if(intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            } else break;
        }
        result.add(newInterval);
        for(;i<intervals.length;i++){
            result.add(intervals[i]);
        }
        System.out.println(result.size());
        return result.toArray(int[][]::new);
    }
}