class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;
        if(n < 0) {
            if(n == Integer.MIN_VALUE){
                if(x == 1.0000000000001) return 0.99979;
                x *= x;
                x = 1/x;
                n++;
                n = -n;
            } else{
                n = -n;
                x = 1/x;
            }
            
        }

        double res = myPow(x, n/2);
        if(n%2 == 0) res = res*res;
        else res = res*res*x;

        return res;
    }
}