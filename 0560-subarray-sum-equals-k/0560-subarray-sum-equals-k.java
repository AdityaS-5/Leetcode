class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> pres = new HashMap<>();
        int sum = 0;
        int count = 0;
        pres.put(0,1);
        for(int i=0;i<n;i++){
            sum += nums[i];
            
            int rem = sum - k;
            
            if(pres.containsKey(rem)){
                count+=pres.get(rem);
            }
            
                pres.put(sum,pres.getOrDefault(sum,0)+1);
            
        }
        return count;
    }
}