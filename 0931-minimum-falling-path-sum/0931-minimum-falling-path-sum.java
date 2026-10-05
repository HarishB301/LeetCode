class Solution {
    public int minFallingPathSum(int[][] m) {
        int n=m.length;
        int[][] dp=new int[n][n];
        for(int arr[]:dp) Arrays.fill(arr,Integer.MAX_VALUE);
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){     
        //         if(i==0) dp[i][j]=m[i][j];
        //         else{
        //             int value=m[i][j];
        //             if(j==0){
        //                 dp[i][j]=value+Math.min(dp[i-1][j],dp[i-1][j+1]);
        //             }else if(j==n-1){
        //                 dp[i][j]=value+Math.min(dp[i-1][j-1],dp[i-1][j]);
        //             }else{
        //                 dp[i][j]=value+Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1]);
        //             }
        //         }
        //     }
        // }
        // int ans=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     ans=Math.min(ans,dp[n-1][i]);
        // }
        // return ans;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,min(n-1,i,n,m,dp));
        }
        return ans;
    }
    public int min(int r,int c,int n,int[][] m,int[][] dp){
        if( c<0 || c>=n) return 100000;
        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
        if(r==0){
          return m[r][c];
        }
        int top=min(r-1,c,n,m,dp);
        int middle=min(r-1,c-1,n,m,dp);
        int right=min(r-1,c+1,n,m,dp);
        return dp[r][c]=m[r][c]+Math.min(top,Math.min(middle,right));
        
    }
}