package DecodeString;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                int num = c - '0';
                while( i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                intStack.push(num);
            }
            else if(c == '['){
                strStack.push(sb.toString());
                sb = new StringBuilder();
            }
            else if(c == ']'){
                int n = intStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int j = 0; j < n; j++){
                    temp.append(sb);
                }
                sb = temp;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
