class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n) return 0;
        int[][] dp=new int[n][m];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return fun(s,n-1,t,m-1,dp);
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