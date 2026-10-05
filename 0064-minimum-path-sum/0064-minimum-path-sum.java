class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(row==0 && col==0) dp[row][col]=grid[0][0];
                else if(row==0){
                    dp[row][col]=dp[row][col-1]+grid[row][col];
                }else if(col==0){
                    dp[row][col]=dp[row-1][col]+grid[row][col];
                }
                else{
                    int min=Math.min(dp[row-1][col],dp[row][col-1]);
                    dp[row][col]=grid[row][col]+min;
                }
            }
        }
        return dp[m-1][n-1];
    }
}