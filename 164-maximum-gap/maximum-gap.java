class Solution {
    public int maximumGap(int[] nums) {
        int N = nums.length;
         int min = nums[0], max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        if (min == max) return 0;
        int bs = (int) Math.ceil((double) (max - min) / (N - 1));
        Pair[] buckets = new Pair[N];
        for(int i = 0;i<N;i++){
            buckets[i] = new Pair();
        }
        for(Pair bucket : buckets){
            bucket.min = Integer.MAX_VALUE;
            bucket.max = Integer.MIN_VALUE;
        }
        for(int n : nums){
            int bi = (n-min)/bs;
            buckets[bi].min = Math.min(buckets[bi].min, n);
            buckets[bi].max = Math.max(buckets[bi].max, n);
        }

        int maxGap = bs;
        int prevmax = buckets[0].max;
        for(int i = 1;i<N;i++){
            if(buckets[i].min == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, buckets[i].min-prevmax);
            prevmax = buckets[i].max;
        }
        return maxGap;
    }
}

class Pair {
    public int max;
    public int min;
}