class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(n,arr,0,k,dp);
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
