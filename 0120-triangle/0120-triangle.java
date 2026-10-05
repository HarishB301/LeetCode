class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int m=tri.size();
        int dp[][]=new int[m][m];
        for(int arr[]:dp) Arrays.fill(arr,Integer.MIN_VALUE);
        return min(0,0,tri,dp,m);
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<=i;j++){
        //         int value=tri.get(i).get(j);
        //         if(i==0 && j==0) dp[0][0]=value;
        //         else if(j==0){
        //             dp[i][j]=value+dp[i-1][j];
        //          }else if(i==j){
        //             dp[i][j]=value+dp[i-1][j-1];
        //          }else{
        //             dp[i][j]=value+Math.min(dp[i-1][j],dp[i-1][j-1]);
        //          }
        //     }
        // }
        // int ans=Integer.MAX_VALUE;
        // for(int i=0;i<m;i++){
        //     ans=Math.min(dp[m-1][i],ans);
        // }
        // return ans;
       
    }
   public int min(int r, int c, List<List<Integer>> tri, int[][] dp, int m) {
        if (r == m - 1) return tri.get(m - 1).get(c);
        
        
        if (dp[r][c] != Integer.MIN_VALUE) return dp[r][c];
        
        int down = min(r + 1, c, tri, dp, m);
        int dia = min(r + 1, c + 1, tri, dp, m);
        
        return dp[r][c] = (tri.get(r).get(c) + Math.min(down, dia));
    }
}