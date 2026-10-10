class Solution {
    public int maximalSquare(char[][] m) {
        int row=m.length;
        int col=m[0].length;
        int[][] dp=new int[row][col];
        int maxSide=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(m[i][j]=='1'){
                    if(i==0 || j==0) dp[i][j]=1;
                    else{
                       dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
}