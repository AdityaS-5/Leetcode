class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;
        char[][] mat = new char[rows][cols];
        int ind=0;
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(ind<n){
                    mat[i][j] = encodedText.charAt(ind);
                    ind++;
                }else{
                    mat[i][j] = ' ';
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cols;i++){
            int k =i;
            int j=0;
            while(j<rows){
                if(k>=cols)break;
                sb.append(mat[j][k]);
                
                k++;
                j++;
            }
        }
        int end = sb.length();
        for(int i=end-1;i>=0;i--){
            if(sb.charAt(i)==' ')end--;
            else break;
        }
        return sb.substring(0,end);
    }
}