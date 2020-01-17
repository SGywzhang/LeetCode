package EvaluateReversePolishNotation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String operations = "+-*/";

        for(String str : tokens){

            if(!operations.contains(str)){
                stack.push(str);
            }
            else{
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch(str){
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.parseInt(stack.peek());
    }
}