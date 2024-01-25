class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        if(intervals.length == 0) return 0;
        int e = intervals[0][1];
        int count = 0;
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] < e){
                count++;
            } else{
                e = intervals[i][1];
            }
        }
        return count;
    }
}

class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // if(a[0] == b[0]){
                return a[1]-b[1];
            // }
            // return a[0] - b[0];
        }
    }