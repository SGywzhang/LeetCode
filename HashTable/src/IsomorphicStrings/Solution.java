package IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> smap = new HashMap<>();
        Map<Character,Character> tmap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){

            if(smap.containsKey(s.charAt(i))){
                if(smap.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }
            else{
                if(tmap.containsKey(t.charAt(i))){
                    return false;
                }
                smap.put(s.charAt(i), t.charAt(i));
                tmap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}