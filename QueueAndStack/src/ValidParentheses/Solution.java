package ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        String left = "([{";
        String right = ")]}";
        Stack<Character> stack = new Stack<>();
        for( char ch: s.toCharArray()){
            if(left.indexOf(ch) != -1){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty() || left.indexOf(stack.peek()) != right.indexOf(ch)){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}