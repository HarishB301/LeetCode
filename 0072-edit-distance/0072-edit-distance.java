class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int arr[]:dp) Arrays.fill(arr,-1);
        return fun(word1,n-1,word2,m-1,dp);
    }
    public int fun(String s,int n,String t, int m,int[][] dp){
        if(m<0) return n+1;
        if(n<0) return m+1;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            return dp[n][m]=fun(s,n-1,t,m-1,dp);
        }else{
            int insert=1+fun(s,n,t,m-1,dp);
            int delete=1+fun(s,n-1,t,m,dp);
            int replace=1+fun(s,n-1,t,m-1,dp);
            return dp[n][m]=Math.min(insert,Math.min(delete,replace));
        }
    }
}