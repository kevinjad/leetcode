class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] vals = new int[n];
        for(int num : nums){
            vals[num] += num;
        }
        int skip = 0;
        int take = 0;
        for(int i = 0;i<n;i++){
            int takei = skip + vals[i];
            int skipi = Math.max(skip, take);

            skip = skipi;
            take = takei;
        }
        return Math.max(skip, take);
    }
}