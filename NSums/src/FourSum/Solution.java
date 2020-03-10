package FourSum;

import java.util.*;

class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//
//        for(int i = 0; i < nums.length - 3; i++){
//            if(i > 0 && nums[i - 1] == nums[i]) continue;
//            for(int j = i + 1; j < nums.length - 2; j++){
//                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
//                int left = j + 1;
//                int right = nums.length - 1;
//                int sum = target - nums[i] - nums[j];
//                while(left < right){
//                    if(sum == nums[left] + nums[right]){
//                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while(left < right && nums[left] == nums[left + 1])  left++;
//                        while(left < right && nums[right] == nums[right - 1])  right--;
//                        left++;
//                        right--;
//                    }
//                    else if(sum > nums[left] + nums[right]){
//                        left++;
//                    }
//                    else{
//                        right--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        Map<Integer, List<int[]>> twoSumMap = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            if (i > 1 && num[i] == num[i - 2]) continue;

            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 2 && num[j] == num[j - 2]) continue;

                if (twoSumMap.containsKey(target - (num[i] + num[j]))) {

                    List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));

                    for (int[] pair : ls) {
                        int m1 = Math.min(pair[0], i);
                        int m2 = Math.min(pair[1], j);
                        int m3 = Math.max(pair[0], i);
                        int m4 = Math.max(pair[1], j);

                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;

                        res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));
                    }
                }
                twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[] {i, j});
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}