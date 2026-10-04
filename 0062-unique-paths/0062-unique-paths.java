class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return matrix(0,0,m,n,dp);
    }
    public int matrix(int row,int col,int m,int n,int[][] dp){
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=matrix(row,col+1,m,n,dp)+matrix(row+1,col,m,n,dp);
    }
}