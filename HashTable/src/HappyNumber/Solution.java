package HappyNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(set.add(n)){
            n = getSum(n);
            if(n == 1) return true;
        }
        return false;
    }

    int getSum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10) * (n % 10);
            n/=10;
        }
        return sum;
    }
}
