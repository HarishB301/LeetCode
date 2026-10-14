class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n) return 0;
        int[][] dp=new int[n+1][m+1];
        // for(int arr[]:dp) Arrays.fill(arr,-1);
        // return fun(s,n-1,t,m-1,dp);
       

       for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(j==0) dp[i][j]=1;
            else if(i==0) dp[i][j]=0;
            else if(s.charAt(i-1)==t.charAt(j-1)){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }else dp[i][j]=dp[i-1][j];
        }
       }

       return dp[n][m];

    }
    public int fun(String s,int n,String t,int m,int[][] dp){
        if(m<0) return 1;
        if(n<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            return dp[n][m]=fun(s,n-1,t,m-1,dp)+fun(s,n-1,t,m,dp);
        }else return dp[n][m]=fun(s,n-1,t,m,dp);
    }
}