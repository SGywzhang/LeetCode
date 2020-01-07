package PascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if(numRows == 0) return res;

        res.add(Arrays.asList(1));

        for(int i = 1; i < numRows; i++){

            List<Integer> list = new ArrayList<>();
            List<Integer> preList = res.get(i-1);
            list.add(1);

            for(int j = 1; j < preList.size(); j++){
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}