package ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;

        for(int i = 2; i < n; i++){
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n-1];
    }
}