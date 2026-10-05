class Solution {
    public int minFallingPathSum(int[][] m) {
        int n=m.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){     
                if(i==0) dp[i][j]=m[i][j];
                else{
                    int value=m[i][j];
                    if(j==0){
                        dp[i][j]=value+Math.min(dp[i-1][j],dp[i-1][j+1]);
                    }else if(j==n-1){
                        dp[i][j]=value+Math.min(dp[i-1][j-1],dp[i-1][j]);
                    }else{
                        dp[i][j]=value+Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
                    }
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