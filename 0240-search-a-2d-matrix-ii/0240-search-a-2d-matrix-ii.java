class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        if( target < mat[0][0] || target > mat[m - 1][n - 1] ){
              return false;
        }
       int row=0,col=n-1;
       while(row<m && col>=0){
         if(mat[row][col]==target) return true;
         else if(mat[row][col]>target) col--;
         else row++;
       }

        return false;
    }
}