class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> l = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            Set<Integer> st  = new HashSet<>();
            for(int j =i+1;j<nums.length;j++){
                int k = -(nums[i]+nums[j]);
                if(st.contains(k)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);
                    Collections.sort(temp);
                    l.add(temp);
                }
                st.add(nums[j]);
            }
        }
        List<List<Integer>> immutableList = List.copyOf(l);
        return immutableList;
    }
}