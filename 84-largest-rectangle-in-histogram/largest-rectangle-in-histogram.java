class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for(int i = 0;i< heights.length;i++){
            int indexToPutInStack = i;
            while(!stack.isEmpty() && stack.peek().value > heights[i]){
                Pair p = stack.pop();
                maxArea = Math.max(maxArea, p.value*(i-p.index));
                indexToPutInStack = p.index;
            }
            stack.push(new Pair(indexToPutInStack,heights[i]));
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            maxArea = Math.max(maxArea, p.value*(heights.length-p.index));
        }
        return maxArea;
    }
}

class Pair{
    int index;
    int value;

    public Pair(int i, int v){
        index = i;
        value = v;
    }

    public Pair (){}
}