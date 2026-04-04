class Solution {
    public long requiredTime(int[] piles, int speed){
        long time= 0;
        for(int i=0;i<piles.length;i++){

            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt(); 
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            long time = requiredTime(piles,mid);
            if(time<=h){
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