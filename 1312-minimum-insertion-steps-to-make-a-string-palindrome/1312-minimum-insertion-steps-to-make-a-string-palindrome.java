class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        String s1="";
        for(int i=n-1;i>=0;i--) s1+=s.charAt(i);
        int[] dp=new int[n+1];
        int[] dp1=new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0 ) dp1[j]=0;
                else if(s.charAt(i-1)==s1.charAt(j-1)){
                    dp1[j]=1+dp[j-1];
                }else{
                    dp1[j]=Math.max(dp[j],dp1[j-1]);
                }
            }
            dp=Arrays.copyOf(dp1,n+1);
        }
        return dp[n]==n ? 0 : n-dp[n];
    }
}