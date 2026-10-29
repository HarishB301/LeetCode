class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        if( target < mat[0][0] || target > mat[m - 1][n - 1] ){
              return false;
        }
        int low=0,high=m*n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/n;
            int col=mid%n;
            if(mat[row][col]==target) return true;
            else if(mat[row][col]<target){
                  low=mid+1;
            }else high=mid-1;
        }
        return false;
    }
}