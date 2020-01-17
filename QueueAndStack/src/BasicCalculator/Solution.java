package BasicCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        List<String> infix = toInfix(s);
        List<String> suffix = infixToSuffix(infix);
        return calculate(suffix);
    }

    public List<String> toInfix (String s){
        String str = s.replaceAll("\\s+","");
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < str.length()){
            if(str.charAt(index) < '0' ||
                    str.charAt(index) > '9'){
                res.add("" + str.charAt(index));
                index++;
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(index < str.length() && (str.charAt(index) >= '0' && str.charAt(index) <= '9')){
                    sb.append(str.charAt(index));
                    index++;
                }
                res.add(sb.toString());
            }
        }
        return res;
    }

    public List<String> infixToSuffix(List<String> list){

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for(String str : list){
            if(str.matches("\\d+")){
                res.add(str);
            }
            else if(str.equals("(")){
                stack.push(str);
            }
            else if(str.equals(")")){
                while(!stack.peek().equals("(")){
                    res.add(stack.pop());
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && getPrority(str) <= getPrority(stack.peek())){
                    res.add(stack.pop());
                }
                stack.push(str);
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public int getPrority(String s){
        int res = 0;
        switch(s){
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                break;
        }
        return res;
    }


    public int calculate (List<String> list){

        Stack<String> stack = new Stack<>();
        for(String str : list){
            if(str.matches("\\d+")){
                stack.push(str);
            }
            else{
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                int temp = 0;

                switch(str){
                    case "+":
                        temp = n1 + n2;
                        break;
                    case "-":
                        temp = n2 - n1;
                        break;
                    case "*":
                        temp = n1 * n2;
                        break;
                    case "/":
                        temp = n2 / n1;
                        break;
                    default:
                        break;
                }
                stack.push(""+temp);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}