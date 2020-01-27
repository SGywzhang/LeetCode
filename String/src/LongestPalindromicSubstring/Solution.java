package LongestPalindromicSubstring;

class Solution {
    int left = 0;
    int maxLen = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;

        for(int i = 0; i < s.length(); i++){
            helper(s,i,i);
            helper(s,i,i + 1);
        }
        return s.substring(left, left + maxLen);
    }

    void helper(String s, int l, int r){
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > maxLen){
                left = l;
                maxLen = r - l + 1;
            }
            r++;
            l--;
        }
    }
}