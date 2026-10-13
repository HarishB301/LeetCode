class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] dp=new int[m+1];
        int[] dp1=new int[m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0 ) dp1[j]=0;
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp1[j]=1+dp[j-1];
                }else{
                    dp1[j]=Math.max(dp[j],dp1[j-1]);
                }
            }
            dp=Arrays.copyOf(dp1,m+1);
        }
        return n+m-2*dp[m];
    }
}