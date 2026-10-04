class Solution {
    public int uniquePathsWithObstacles(int[][] Grid) {
        int m=Grid.length;
        int n=Grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(Grid[row][col]==1) dp[row][col]=0;
                else if(row==0 && col==0) dp[row][col]=1;
                else{
                    int fromLeft = (col > 0) ? dp[row][col - 1] : 0;
                    int fromUp = (row > 0) ? dp[row - 1][col] : 0;
                    dp[row][col] = fromLeft + fromUp;
                }
            }
        }
        
        // for(int[] arr:dp){
        //     Arrays.fill(arr,-1);
        // }
        // return matrix(0,0,m,n,dp,Grid);
        return dp[m-1][n-1];
    }
    public int matrix(int row,int col,int m,int n,int[][] dp,int[][] Grid){
        if(row<0 || row>=m || col<0 || col>=n) return 0;
        if(Grid[row][col]==1) return 0;
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=matrix(row,col+1,m,n,dp,Grid)+matrix(row+1,col,m,n,dp,Grid);
    }
}
    