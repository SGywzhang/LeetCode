package CountBits;

import java.util.Arrays;

class Solution {
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i++){
            res[i] = getBits(i);
        }
        return res;
    }

    static int getBits(int n){
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }
}
