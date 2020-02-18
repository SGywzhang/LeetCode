package ImplementStr;

//class Solution {
//    public int strStr(String haystack, String needle) {
//        int index = -1;
//        int h = haystack.length();
//        int n = needle.length();
//
//        for(int i = 0; i < h - n + 1; i++){
//            if(haystack.substring(i, i + n).equals(needle)) return i;
//        }
//        return index;
//    }
//}

import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {

        if(needle.length() ==0) return 0;
        if(haystack.length() ==0) return -1;

        int[] next = kmpNext(needle);

        for(int i = 0, j = 0; i < haystack.length(); i++){

            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j -1];
            }

            if(haystack.charAt(i) == needle.charAt(j)){
            j++;
        }
        if(j == needle.length())
            return i-j+1;
    }
        return -1;
    }

    public static int[] kmpNext(String needle){

        int[] next = new int[needle.length()];

        for(int i = 1, j = 0; i < needle.length(); i++){

            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j -1];
            }

            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }

            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        int[] arr = kmpNext("abcd#dcba");
        System.out.println(Arrays.toString(arr));
    }
}

//class Solution {
//    public int strStr(String haystack, String needle) {
//
//        int i = 0;
//        int j = 0;
//
//        while(i<haystack.length() && j<needle.length()){
//
//            if(haystack.charAt(i) == needle.charAt(j)){
//                i++;
//                j++;
//            }
//            else{
//                i = i - j + 1;
//                j = 0;
//            }
//        }
//
//        if(j == needle.length())
//            return i - j;
//        else
//            return -1;
//    }
//}