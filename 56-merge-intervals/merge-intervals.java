class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int last = 0;
        for(int i = 1;i<intervals.length;i++){
            int[] lastInterval = result.get(last);
            if(lastInterval[1]>=intervals[i][0]){
                if(lastInterval[1] < intervals[i][1]){
                    lastInterval[1] = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
                last++;
            }
        }
        return result.toArray(new int[0][]);
    }
}