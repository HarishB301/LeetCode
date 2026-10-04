class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int m=Grid.length;
        int n=Grid[0].length;
        int[][] dp=new int[m+1][n+1];
        
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return matrix(0,0,m,n,dp,Grid);
    }
    public int matrix(int row,int col,int m,int n,int[][] dp,int[][] Grid){
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(Grid[row][col]==1) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=matrix(row,col+1,m,n,dp,Grid)+matrix(row+1,col,m,n,dp,Grid);
    }
}
    