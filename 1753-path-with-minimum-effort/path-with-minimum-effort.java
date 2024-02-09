class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] data = new int[heights.length][heights[0].length];
        for(int[] arr : data) Arrays.fill(arr, Integer.MAX_VALUE);
        minimumEffortPathHelper(0, 0, 0, heights, data);
        return data[heights.length-1][heights[0].length-1];
    }

    public void minimumEffortPathHelper(int max, int i, int j,int[][] height, int[][] data){
        if(i>= height.length || j >= height[0].length || i<0 || j<0) return;
        int val = height[i][j];
        if(max >= data[i][j]) return;
        data[i][j] = Math.min(max,data[i][j]);
        if(i+1 < height.length){
            int diff = Math.abs(height[i+1][j]-val);
            minimumEffortPathHelper(Math.max(diff,max), i+1, j, height, data);
        }
        if(i-1 >=0){
            int diff = Math.abs(height[i-1][j]-val);
            minimumEffortPathHelper(Math.max(diff,max), i-1, j, height, data);
        }
        if(j+1 < height[0].length){
            int diff = Math.abs(height[i][j+1]-val);
            minimumEffortPathHelper(Math.max(diff,max), i, j+1, height, data);
        }
        if(j-1 >=0){
            int diff = Math.abs(height[i][j-1]-val);
            minimumEffortPathHelper(Math.max(diff,max), i, j-1, height, data);
        }
    }
}