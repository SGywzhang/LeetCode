package FibonacciNumber;

class Solution {
    public int fib(int N) {
        if(N < 2) return N;
        int[] temp = new int[N+1];
        temp[0] = 0;
        temp[1] = 1;

        for(int i = 2; i <= N; i++){
            temp[i] = temp[i-1] + temp[i - 2];
        }
        return temp[N];
    }
}