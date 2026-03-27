class Solution {
    public int ncr(int n,int r){
        long res = 1;
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return (int)res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++){
            l.add(ncr(rowIndex,i));
        }
        return l;
    }
}