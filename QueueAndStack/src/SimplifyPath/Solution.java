package SimplifyPath;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");

        for(String str : strs){
            if(str == null || str.length() == 0|| str.equals(".")) continue;
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(str);
            }
        }

        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}
