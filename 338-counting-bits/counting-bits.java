class Solution {
    public int[] countBits(int n) {
        // 0 1 1 2 1 2 2 3 1 2 2
        int[] result = new int[n+1];
        int offset = 1;
        for(int i = 1;i<n+1;i++){
            if(offset*2 == i){
                offset *= 2;
            }
            result[i] = result[i-offset]+1;
        }
        return result;
    }
}