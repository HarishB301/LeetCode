class Solution {
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        // int[][] dp=new int[n][m];
        // for(int arr[]:dp) Arrays.fill(arr,-1);
        // return dp(s,n-1,t,m-1,dp);

        int[] dp=new int[m+1];
       int[] dp1=new int[m+1];
       for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(i==0||j==0){
                if(i==0) dp1[j]=j+1;
                if(j==0) dp1[j]=i+1;
            }
            else if(s.charAt(i-1)==t.charAt(j-1)){
                dp1[j]=dp[j-1];
            }else {
                int insert=1+dp1[j-1];
                int delete=1+dp[j];
                int replace=1+dp[j-1];
                 dp1[j]=Math.min(insert,Math.min(delete,replace));
            }
        }
        dp=Arrays.copyOf(dp1,m+1);
       }
    return dp[m]-1;
    }
    // public int dp(String s,int n,String t, int m,int[][] dp){
    //     if(m<0) return n+1;
    //     if(n<0) return m+1;
    //     if(dp[n][m]!=-1) return dp[n][m];
    //     if(s.charAt(n)==t.charAt(m)){
    //         return dp[n][m]=dp(s,n-1,t,m-1,dp);
    //     }else{
    //         int insert=1+dp(s,n,t,m-1,dp);
    //         int delete=1+dp(s,n-1,t,m,dp);
    //         int replace=1+dp(s,n-1,t,m-1,dp);
    //         return dp[n][m]=Math.min(insert,Math.min(delete,replace));
    //     }
    // }
}