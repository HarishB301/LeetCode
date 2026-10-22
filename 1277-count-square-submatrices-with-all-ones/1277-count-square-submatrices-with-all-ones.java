class Solution {
    public int countSquares(int[][] mat) {
       int m= mat.length;
       int n=mat[0].length;
       int[][] dp=new int[m][n];
       int ans=0;
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 || j==0){
                dp[i][j]=mat[i][j];
                ans+=dp[i][j];
            }else{
                int top=dp[i-1][j];
                int left=dp[i][j-1];
                int dia=dp[i-1][j-1];
                int mini=Math.min(top,Math.min(left,dia));
                if(mat[i][j]==0){
                   dp[i][j]=0;
                }else{
                    dp[i][j]=1+mini;
                    ans+=dp[i][j];
                }
            }
        }
       }
       return ans;
    }
}