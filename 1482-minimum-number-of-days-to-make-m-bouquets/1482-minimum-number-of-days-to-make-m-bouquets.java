class Solution {
    public boolean possible(int[] arr, int day,int m,int k){
        int cnt=0;
        int bouq=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day)cnt++;
            else{
                bouq+=(cnt/k);
                cnt=0;
            }
        }
        bouq+=(cnt/k);
        if(bouq >=m)return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(m*k))return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int ans = -1;
        int low = min;
        int high = max;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k)){
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