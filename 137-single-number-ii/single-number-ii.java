class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int n : nums){
            for(int i = 0;i<32;i++){
                boolean hasbit = (n & (1<<i)) != 0;
                if(hasbit){
                    bits[i] = (bits[i]+1)%3;
                }
            }
        }
        int ans = 0;
        for(int i = 0;i<32;i++){
            if(bits[i] != 0){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}