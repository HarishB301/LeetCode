class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] arr=new int[m+2];
        arr[0]=0;
        arr[m+1]=n;
        Arrays.sort(cuts);
        for(int i=0;i<m;i++) arr[i+1]=cuts[i];
        int[][] dp=new int[m+2][m+2];
        for(int a[]:dp) Arrays.fill(a,-1);
        return fun(1,m,arr,dp);
    }
    public int fun(int i,int j,int[] arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
         int minCost=Integer.MAX_VALUE;
        for(int cut=i;cut<=j;cut++){
            int cost=(arr[j+1]-arr[i-1])+fun(i,cut-1,arr,dp)+fun(cut+1,j,arr,dp);
            minCost=Math.min(minCost,cost);
        }
        return dp[i][j]=minCost;
    }
}