package FourSumII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int a : A){
            for(int b : B){
                int addAB = a + b;
                if(map.containsKey(addAB)){
                    map.put(addAB, map.get(addAB) + 1);
                }
                else{
                    map.put(addAB, 1);
                }
            }
        }

        for(int c : C){
            for(int d : D){
                int addCD = c + d;
                if(map.containsKey(-addCD)){
                    res = res + map.get(-addCD);
                }
            }
        }
        return res;
    }
}