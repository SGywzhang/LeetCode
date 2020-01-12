package SearchForARange;

class Solution {
    public int[] searchRange(int[] nums, int target){
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;
        res[0] = searchFirst(nums, target);
        res[1] = searchSecond(nums, target);
        return res;
    }

    public int searchFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(left >= 0 && left < nums.length && nums[left] == target) return left;
        return -1;
    }

    public int searchSecond(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(right >= 0 && right < nums.length && nums[right] == target) return right;
        return -1;
    }
}