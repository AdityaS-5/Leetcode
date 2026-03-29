import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int[][] ans = new int[n][2];
        int ind = 0;

        int i = 0;

        // Same logic as your working code
        while (i < n) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // merge overlaps
            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            ans[ind][0] = start;
            ans[ind][1] = end;
            ind++;

            i = j; // move to next block
        }

        // return only filled part
        return Arrays.copyOf(ans, ind);
    }
}