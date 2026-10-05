class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int value=grid[i][j];
                if(i==0) dp[i][j]=value;
                else{
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<n;k++){
                        if(k!=j){
                            min=Math.min(dp[i-1][k],min);
                        }
                    }
                    dp[i][j]=value+min;
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}