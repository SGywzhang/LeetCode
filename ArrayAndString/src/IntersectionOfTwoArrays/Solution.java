package IntersectionOfTwoArrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(Integer n1 : nums1){
            set1.add(n1);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n2 : nums2){
            set2.add(n2);
        }

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int count = 0;
        for(int x : set1){
            res[count++] = x;
        }
        return res;
    }
}