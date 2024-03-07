class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i = 0;i<nums.length;i++){
        //     if(map.containsKey(target-nums[i])){
        //         return new int[]{map.get(target-nums[i]), i};
        //     }
        //     map.put(nums[i],i);
        // }
        // return null;

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int start = 0;
        int end = nums.length-1;
        Arrays.sort(nums); // 2 7 11 15
        while(start < end){ //|      |
            if(nums[start]+nums[end] == target){
                if(nums[end] == nums[start]){
                    return new int[]{map.get(nums[start]).get(0), map.get(nums[end]).get(1)};
                }
                return new int[]{map.get(nums[start]).get(0), map.get(nums[end]).get(0)};
            } else if (nums[start]+nums[end] < target){
                start++;
            } else{
                end--;
            }
        }
        return null;
    }
}