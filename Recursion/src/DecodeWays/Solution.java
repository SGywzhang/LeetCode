package DecodeWays;

class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        char[] arr = s.toCharArray();
        return decode(arr, arr.length - 1);
    }

    int decode(char[] arr, int index){
        if(index <= 0){
            return 1;
        }

        int count = 0;
        char cur = arr[index];
        char pre = arr[index - 1];

        if(cur > '0'){
            count = decode(arr, index - 1);
        }

        if(pre == '1' || pre == '2' && cur <= '6'){
            count+= decode(arr, index - 2);
        }
        return count;

    }
}