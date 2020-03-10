package MinimumWindowSubstring;

class Solution {
    public String minWindow(String s, String t) {
        char[] mapT = new char[128];
        char[] mapS = new char[128];
        for(char ch : t.toCharArray()){
            mapT[ch]++;
        }
        String res = "";
        int count = 0;
        int start = 0;
        for(int i= 0; i< s.length(); i++){
            if(mapT[s.charAt(i)] > 0){
                mapS[s.charAt(i)]++;
                if(mapT[s.charAt(i)] >= mapS[s.charAt(i)]){
                    count++;
                }
            }
            if(count == t.length()){
                while(mapS[s.charAt(start)] >mapT[s.charAt(start)] || mapT[s.charAt(start)] == 0){
                    if(mapS[s.charAt(start)] >mapT[s.charAt(start)]){
                        mapS[s.charAt(start)]--;
                    }
                    start++;
                }

                if(res.equals("") || i - start + 1 < res.length()){
                    res = s.substring(start, i+1);
                }
            }


        }
        return res;
    }
}
