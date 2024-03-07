class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> memory = new HashSet<>();
        for(int n : nums){
            memory.add(n);
        }
        return !(memory.size() == nums.length);
    }
}