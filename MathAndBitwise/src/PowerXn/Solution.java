package PowerXn;

class Solution {
    double myPow(double x, int n) {
        double res = 1;
        x = n < 0 ? 1/x : x;
        while(n != 0){
            if(n%2 != 0) res*= x;
            x*=x;
            n/=2;
        }
        return res;
    }
}