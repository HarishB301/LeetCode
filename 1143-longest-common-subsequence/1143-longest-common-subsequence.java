class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[] dp=new int[m+1];
        int[] dp1=new int[m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0 ) dp1[j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp1[j]=1+dp[j-1];
                }else{
                    dp1[j]=Math.max(dp[j],dp1[j-1]);
                }
            }
            dp=Arrays.copyOf(dp1,m+1);
        }
        return dp[m];

        // for(int[] arr:dp) Arrays.fill(arr,-1);
        // return fun(text1,text2,n,m,dp);
    }

    public int fun(String str1,String str2,int n,int m,int[][] dp){
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        else if(str1.charAt(n-1)==str2.charAt(m-1)){
            return dp[n][m]=1+fun(str1,str2,n-1,m-1,dp);
        }else{
            return dp[n][m]=Math.max(fun(str1,str2,n-1,m,dp),fun(str1,str2,n,m-1,dp));
        }
    }
}