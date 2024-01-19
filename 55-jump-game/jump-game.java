class Solution {
    public boolean canJump(int[] nums) {
        // idea is to find the max reach at each index we do this only if the current index is below previous max index else we cannot cross the current index
        int maxReach = 0;
        for(int i = 0;i<nums.length;i++){
            if(i<=maxReach){
                maxReach = Math.max(maxReach, i+nums[i]);
                if(maxReach == nums.length-1) return true;
            } else return false;
        }
        return true;
    }
}