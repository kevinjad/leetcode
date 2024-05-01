class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(s.contains(nums[i])) return true;
            s.add(nums[i]);
            if(i-k>=0) s.remove(nums[i-k]);
        }
        return false;
    }
}