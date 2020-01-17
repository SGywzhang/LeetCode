package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        dfsHelper(n,0,0,res,"");
        return res;
    }

    public static void dfsHelper(int n, int left, int right, List<String>res,String cur){

        if(right == n){
            res.add(cur);
            System.out.println(cur);
            return;
        }
        else{
            if(left < n){
                dfsHelper(n,left + 1,right,res,cur + "(");
            }

            if(right < left){
                dfsHelper(n,left,right + 1,res,cur + ")");
            }
        }
    }

    public static void main(String[] args) {

        generateParenthesis(3);
    }
}