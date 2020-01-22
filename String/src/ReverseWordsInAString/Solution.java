package ReverseWordsInAString;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();

        String[] str = s.trim().split("\\s+");

        Stack<String> stack = new Stack<>();

        for(String ss : str){
            stack.push(ss);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "  hello world!  ";
        String[] strs = str.trim().split("\\s+");
        System.out.println(Arrays.toString(strs));
    }
}