class Solution {
    public int daysRequired(int[] weights,int cap){
        int days=1;
        int avail = cap;
        for(int i=0;i<weights.length;i++){
            if(weights[i]<=avail){
                avail = avail - weights[i];
            }else{
                days++;
                avail = cap-weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE; 
        int high = 0;
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
            low = Math.max(low,weights[i]);
        }
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int currDays = daysRequired(weights,mid);
            if(currDays<=days){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;

    }
}