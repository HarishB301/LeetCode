class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[n]=0;
       for(int ind=n-1;ind>=0;ind--){
            int maxAns=Integer.MIN_VALUE;
            int len=0,maxi=Integer.MIN_VALUE;
            for(int j=ind;j<Math.min(n,ind+k);j++){
                len++;
                maxi=Math.max(maxi,arr[j]);
                int cost=(len*maxi)+dp[j+1];
                maxAns=Math.max(maxAns,cost);
            }

           dp[ind]=maxAns;
       }
       return dp[0];
    }

    int fun(int n,int[] arr,int ind,int k,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int maxAns=Integer.MIN_VALUE;
        int len=0,maxi=Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(n,ind+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int cost=(len*maxi)+fun(n,arr,j+1,k,dp);
            maxAns=Math.max(maxAns,cost);
        }

        return dp[ind]=maxAns;
    }
}
