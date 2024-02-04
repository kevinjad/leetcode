class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        int i = 1;
        for(int x : nums){
            arr[i] = x;
            i++;
        }

        int[][] mem = new int[n+2][n+2];

        return burst(arr, 0, n+1, mem);
    }

    public int burst(int[] arr, int left, int right, int[][] mem){
        // one case
        int ans = 0;
        if(mem[left][right] != 0) return mem[left][right];
        for(int i = left+1;i<right;i++){
            ans = Math.max(ans,arr[i]*arr[left]*arr[right]+burst(arr, left, i, mem)+burst(arr, i, right, mem));
        }
        mem[left][right] = ans;
        return ans;
    }
}