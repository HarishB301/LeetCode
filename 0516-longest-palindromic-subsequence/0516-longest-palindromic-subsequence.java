class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String text1=s;
        String text2="";
        for(int i=n-1;i>=0;i--) text2+=s.charAt(i);
        int[] dp=new int[n+1];
        int[] dp1=new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0 ) dp1[j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp1[j]=1+dp[j-1];
                }else{
                    dp1[j]=Math.max(dp[j],dp1[j-1]);
                }
            }
            dp=Arrays.copyOf(dp1,n+1);
        }
        return dp[n];
    }
}