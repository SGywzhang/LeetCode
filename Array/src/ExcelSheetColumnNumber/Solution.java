package ExcelSheetColumnNumber;

class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() ==0) return 0;
        int res = 0;

        int[] arr = new int[26];

        for(int i = 0, k = 0; i < arr.length; i++, k++){
            arr[i] = 1 + k;
        }

        for(int i = s.length() - 1, n = 1; i >= 0; i--, n = n * 26){
            res += arr[s.charAt(i) - 'A']*n;
        }
        return res;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(2));
        sb.reverse();
        Integer.parseInt(sb.toString(),2);
    }
}
