class Solution {
    public boolean isMatch(String p, String s) {
        int n=s.length();
        int m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        // return fun(s,n-1,p,m-1,dp);
        dp[0][0]=true;
        for(int j=1;j<=m;j++) dp[0][j]=false;
        for (int i = 1; i <= n; i++) {
            boolean flag=true;
           for(int k=1;k<=i;k++){
                if (s.charAt(k - 1) != '*') {
                    flag=false;
                    break;
                }
           }
            dp[i][0]=flag;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
               
                if(s.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }else if(s.charAt(i-1)==p.charAt(j-1) || s.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public boolean fun(String s,int i,String p,int j,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 && j<0){
            for(int a=0;a<=i;a++){
                if(s.charAt(a)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)=='*'){
            return dp[i][j]=fun(s,i,p,j-1,dp) || fun(s,i-1,p,j,dp);
        }
        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?'){
            return dp[i][j]=fun(s,i-1,p,j-1,dp);
        }
        return dp[i][j]=false;
    }
}