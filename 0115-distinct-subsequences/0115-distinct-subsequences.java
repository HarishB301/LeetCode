class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n) return 0;
        // int[][] dp=new int[n+1][m+1];
        // for(int arr[]:dp) Arrays.fill(arr,-1);
        // return fun(s,n-1,t,m-1,dp);
       

       int[] dp=new int[m+1];
       int[] dp1=new int[m+1];
       for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(j==0) dp1[j]=1;
            else if(i==0) dp1[j]=0;
            else if(s.charAt(i-1)==t.charAt(j-1)){
                dp1[j]=dp[j-1]+dp[j];
            }else dp1[j]=dp[j];
        }
        dp=Arrays.copyOf(dp1,m+1);
       }

       return dp[m];

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