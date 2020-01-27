package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0, res =0;

        while(right < s.length()){
            if(set.add(s.charAt(right))){
                res = Math.max(res, set.size());
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
}
