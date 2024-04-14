class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cursum = 0;

        int min = Integer.MAX_VALUE;
        int mcs = 0;
        
        int total = 0;
        for(int x : nums){
            // calculate max in non circular
            cursum += x;
            max = Math.max(max,cursum);
            if(cursum < 0) cursum = 0;

            // calculate max in non circular
            mcs += x;
             min = Math.min(min,mcs);
            if(mcs > 0) mcs = 0;
           

            total += x;
        }

        if(total-min == 0) return max;
        return Math.max(total-min,max);        
    }
}