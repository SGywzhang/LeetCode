package RomanToInteger;

class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        if(s.contains("IV")) res -=2;
        if(s.contains("IX")) res -=2;
        if(s.contains("XL")) res -=20;
        if(s.contains("XC")) res -=20;
        if(s.contains("CD")) res -=200;
        if(s.contains("CM")) res -=200;

        for(char ch:s.toCharArray()){
            if(ch == 'I') res+=1;
            else if(ch == 'V') res+=5;
            else if(ch == 'X') res+=10;
            else if(ch == 'L') res+=50;
            else if(ch == 'C') res+=100;
            else if(ch == 'D') res+=500;
            else if(ch == 'M') res+=1000;
        }
        return res;
    }
}