package SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int peak = findPeak(nums);
        if(peak >= 0 && target >= nums[0] && target <= nums[peak]){
            return binarySearch(nums, 0, peak, target);
        }
        else{
            return binarySearch(nums, peak + 1, nums.length - 1, target);
        }
    }

    public int findPeak(int[] nums){
        if(nums.length == 1) return 0;
        if(nums[0] < nums[nums.length - 1]) return nums.length -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) return mid;
            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return 0;
    }

    public int binarySearch(int[] nums, int left, int right, int target){

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}