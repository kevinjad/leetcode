class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<int[]> result = new ArrayList<>();
        List<String> res = new ArrayList<>();
        int prev = nums[0];
        int[] temp = new int[2];
        temp[0] = prev;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]-nums[i-1] != 1) {
                temp[1] = nums[i-1];
                result.add(temp);
                temp = new int[2];
                temp[0] = nums[i];
            }
        }
        temp[1] = nums[nums.length-1];
        result.add(temp);
        for(int[] e : result){
            if(e[0] == e[1]){
                res.add(e[0]+"");
            } else {
                res.add(e[0]+"->"+e[1]);
            }
        }
        
        return res;
    }
}