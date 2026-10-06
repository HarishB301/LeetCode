class Solution {
    public int cherryPickup(int[][] g) {
        int n=g.length;
        int m=g[0].length;
        int[][][] dp=new int[n][m][m];
        for(int[][] arr:dp){
            for(int[] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return pickup(0,0,m-1,n,m,g,dp);
    }
    public int pickup(int i,int j,int k,int n,int m,int[][] g,int[][][] dp){
        if(j>=m || j<0 || k>=m || k<0) return (int) -1e9;
        int cherries = (j==k) ? g[i][j]:g[i][j]+g[i][k];
        if(i==n-1) return cherries;
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int max=Integer.MIN_VALUE;
        for(int x=-1;x<=+1;x++){
            for(int y=-1;y<=+1;y++){
                max=Math.max(max,pickup(i+1,j+x,k+y,n,m,g,dp));

            }
        }
        return dp[i][j][k]=max+cherries;
    }
}