class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[] arr=new int[m+2];
        arr[0]=0;
        arr[m+1]=n;
        Arrays.sort(cuts);
        for(int i=0;i<m;i++) arr[i+1]=cuts[i];
        int[][] dp=new int[m+2][m+2];
        for(int i=m;i>=1;i--){
            for(int j=i;j<=m;j++){
                  int minCost=Integer.MAX_VALUE;
                    for(int cut=i;cut<=j;cut++){
                        int cost=(arr[j+1]-arr[i-1])+dp[i][cut-1]+dp[cut+1][j];
                        minCost=Math.min(minCost,cost);
                    }
                    dp[i][j]=minCost;
            }
        }

        return dp[1][m];
        
    }
  
}