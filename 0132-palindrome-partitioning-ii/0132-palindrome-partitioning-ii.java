class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Boolean[][] pd=new Boolean[n][n];
        Arrays.fill(dp,-1);
        return fun(0,s,dp,pd);
    }
    int fun(int i,String s,int[] dp,Boolean[][] pd){
        if(i==s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int minCost=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j,pd)){
                int cost = (j==s.length()-1) ? 0 : 1+fun(j+1,s,dp,pd); 
                minCost=Math.min(minCost,cost);
            }
        }
        return dp[i]=minCost;
    }

    boolean isPalindrome(String s,int i,int j,Boolean[][] pd){
        if(i>j) return true;
        if(pd[i][j]!=null) return pd[i][j];
        return pd[i][j]=(s.charAt(i)==s.charAt(j)) && isPalindrome(s,i+1,j-1,pd);
    }
}