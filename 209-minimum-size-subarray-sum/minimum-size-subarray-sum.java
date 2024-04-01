class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int currsum = 0;
        int minlen = Integer.MAX_VALUE;
        while(i<=j && j<nums.length){
            currsum += nums[j];
            while(target<=currsum){
                minlen = Math.min(minlen,j-i+1);
                currsum -= nums[i];
                i++;
            }
            j++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}