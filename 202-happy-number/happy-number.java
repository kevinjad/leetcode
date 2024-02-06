class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            int t = n;
            int sum = 0;
            while(t != 0){
                int rem = t%10;
                sum += rem*rem;
                t = t/10;
            }
            n = sum;
        }
        return n==1;
    }
}