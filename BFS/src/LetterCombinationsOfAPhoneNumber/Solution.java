package LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;

        String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for(int i = 0; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            String temp = dict[num];
            while(queue.peek().length() == i){
                String cur = queue.poll();
                for(char ch : temp.toCharArray()){
                    queue.offer(cur + String.valueOf(ch));
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
