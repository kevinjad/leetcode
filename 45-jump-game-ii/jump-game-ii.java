class Solution {
    public int jump(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            nums[i] = Math.max(i+nums[i], nums[i-1]);
        }
        int i = 0;
        int ans = 0;
        while(i < nums.length-1){
            ans++;
            i = nums[i];
        }
        return ans;
    }
}