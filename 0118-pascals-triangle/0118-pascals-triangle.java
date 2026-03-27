class Solution {
    public List<Integer> Row(int row){
        int a = 1;
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for(int i=1;i<row;i++){
            a = a * (row-i);
            a = a / i;
            ans.add(a);
        }
        
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<numRows+1;i++){
            res.add(Row(i));
        }
        return res;
    }
}