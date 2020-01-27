package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while(left < right){
                    if(sum == nums[left] + nums[right]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1])  left++;
                        while(left < right && nums[right] == nums[right - 1])  right--;
                        left++;
                        right--;
                    }
                    else if(sum > nums[left] + nums[right]){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return res;
    }
}