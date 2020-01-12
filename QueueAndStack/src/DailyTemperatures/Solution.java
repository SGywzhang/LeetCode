package DailyTemperatures;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                    int index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        return res;
    }
}