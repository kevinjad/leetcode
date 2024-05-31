class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        Map<Integer,Integer> mem = new HashMap<>();
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(mem.containsKey(arr[i]-difference)){
                int d = arr[i]-difference;
                mem.put(arr[i],mem.get(d)+1);
            } else {
                mem.put(arr[i], 1);
            }
            count = Math.max(count, mem.get(arr[i]));
        }
        return count;
    }
}