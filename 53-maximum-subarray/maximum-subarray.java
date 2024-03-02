class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int measure = 0;
        for(int n : nums){
            measure += n;
            max = Math.max(max, measure);
            if(measure < 0) measure = 0;
        }
        return max;
    }
}