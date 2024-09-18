class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxarea = 0;
        for(int i = 0; i<heights.length;i++){
            int ips = i;
            if(st.isEmpty()) st.push(ips);
            else {
                while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                    int ind = st.pop();
                    maxarea = Math.max(maxarea, (i-ind)*heights[ind]);
                    ips = ind;
                }
                st.push(ips);
                heights[ips] = heights[i];
            }
        }
        while(!st.isEmpty()){
            int ind = st.pop();
            maxarea = Math.max(maxarea, (heights.length-ind)*heights[ind]);
        }
        return maxarea;
    }
}