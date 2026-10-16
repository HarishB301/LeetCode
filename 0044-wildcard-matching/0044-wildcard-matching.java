class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][] dp=new Boolean[n+1][m+1];
        return fun(p,m-1,s,n-1,dp);
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
        if(dp[j][i]!=null) return dp[j][i];
        if(s.charAt(i)=='*'){
            return dp[j][i]=fun(s,i,p,j-1,dp) || fun(s,i-1,p,j,dp);
        }
        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?'){
            return dp[j][i]=fun(s,i-1,p,j-1,dp);
        }
        return dp[j][i]=false;
    }
}