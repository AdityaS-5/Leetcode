class Solution {
    public int lowerbound(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int upperbound(int[] nums,int target){
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int lb = lowerbound(nums, target);
        int ub = upperbound(nums, target);

        // Check if target exists
        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub - 1};
    }
}