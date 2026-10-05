class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        // for(int row=0;row<m;row++){
        //     for(int col=0;col<n;col++){
        //         if(row==0 && col==0) dp[row][col]=grid[0][0];
        //         else if(row==0){
        //             dp[row][col]=dp[row][col-1]+grid[row][col];
        //         }else if(col==0){
        //             dp[row][col]=dp[row-1][col]+grid[row][col];
        //         }
        //         else{
        //             int min=Math.min(dp[row-1][col],dp[row][col-1]);
        //             dp[row][col]=grid[row][col]+min;
        //         }
        //     }
        // }
        // return dp[m-1][n-1];
        return min1(m-1,n-1,grid,dp);
    }
    public int min(int m,int n,int row,int col,int[][] grid,int[][] dp){
        if(col>=n || row>=m) return Integer.MAX_VALUE;
        if(row==m-1 && col==n-1) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int left=min(m,n,row+1,col,grid,dp);
        int right=min(m,n,row,col+1,grid,dp);
        return dp[row][col]=grid[row][col]+Math.min(left,right);
    }
     public int min1(int row,int col,int[][] grid,int[][] dp){
        if(col<0 || row<0) return Integer.MAX_VALUE;
        if(row==0 && col==0) return grid[0][0];
        if(dp[row][col]!=-1) return dp[row][col];
        int left=min1(row-1,col,grid,dp);
        int right=min1(row,col-1,grid,dp);
        return dp[row][col]=grid[row][col]+Math.min(left,right);
    }
}