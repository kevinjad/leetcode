class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 23 25 29 35 42
        Map<Integer,Integer> mem = new HashMap<>();
        int sum = 0;
        mem.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(mem.containsKey(sum%k)){
                if(i-mem.get(sum%k)>=2) return true;
            } else 
            mem.put(sum%k, i);
        }
        return false;
    }
}