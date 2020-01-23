package RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(0, 4, res, s,"");
        return res;
    }

    static void dfs(int index, int remain, List<String> res, String s, String cur){
        if(remain == 0){
            if(index == s.length()){
                res.add(cur);
            }
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(index + i > s.length()) break;
            if(i != 1 && s.charAt(index) == '0') break;
            String temp = s.substring(index, index + i);

            if(Integer.parseInt(temp) <= 255){
                dfs(index + i, remain - 1, res, s, cur + temp + (remain == 1 ? "" : "."));
            }
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
}
