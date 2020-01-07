package SumOfTwoInteger;

class Solution {
    public int getSum(int a, int b) {

        if(a == 0) return b;
        if(b == 0) return a;

        while(b != 0){
            int add = (a & b) << 1;
            a = a ^ b;
            b = add;
        }
        return a;
    }
}