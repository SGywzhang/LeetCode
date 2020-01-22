package CustomSortString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
//class Solution {
//    public String customSortString(String S, String T) {
//        int[] count = new int[26];
//        StringBuilder sb = new StringBuilder();
//        for(char c : T.toCharArray()){
//            count[c - 'a']++;
//        }
//
//        for(char c : S.toCharArray()){
//            while(count[c - 'a'] > 0){
//                sb.append(c);
//                count[c - 'a']--;
//            }
//        }
//
//        for(char i = 'a'; i <= 'z'; i++){
//            while(count[i - 'a'] > 0){
//                sb.append(i);
//                count[i - 'a']--;
//            }
//        }
//        return sb.toString();
//    }
//}
class Solution {
    Map<Character, Integer> map;
    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0) return T;
        map = new HashMap<>();
        char[] arr1 = S.toCharArray();
        for(int i = 0; i < arr1.length; i++){
            map.put(arr1[i],i);
        }
        char[] arr2 = T.toCharArray();
        quickSort(arr2, 0, arr2.length - 1);
        return String.valueOf(arr2);
    }

    public void quickSort(char[] nums, int left, int right){

        int l = left;
        int r = right;
        char pivot = nums[l + (r - l) / 2];

        while(l < r){
            while(map.getOrDefault(nums[l], -1) < map.getOrDefault(pivot,-1)){
                l++;
            }
            while(map.getOrDefault(nums[r], -1)  > map.getOrDefault(pivot,-1)){
                r--;
            }
            if(l <= r){
                char temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        if(left < r){
            quickSort(nums, left, r);
        }

        if(right > l){
            quickSort(nums, l, right);
        }
    }
}