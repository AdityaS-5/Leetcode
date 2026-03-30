import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] ans = new int[n][2];
        int ind = 0;

        for(int i =0;i<n;i++){
            if(i==0 || intervals[i][0]>ans[ind-1][1]){
                ans[ind][0] = intervals[i][0];
                ans[ind][1] = intervals[i][1];
                ind++;
                
            }
            else{
                ans[ind-1][1] = Math.max(ans[ind-1][1],intervals[i][1]);
                
            }
        }
        return Arrays.copyOf(ans,ind);
    }
}