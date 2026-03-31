class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int preffix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(preffix == 0)preffix = 1;
            if(suffix == 0)suffix = 1;
            preffix = preffix * nums[i];
            suffix = suffix * nums[n - i - 1];
            max = Math.max(max,Math.max(preffix,suffix));
        }
        return max;
    }
}