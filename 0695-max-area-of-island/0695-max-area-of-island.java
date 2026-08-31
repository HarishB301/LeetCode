class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m =grid.length;
        int n=grid[0].length;
        int Island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    int count=dfs(i,j,grid);
                    Island=Math.max(Island,count);
                }
            }
        }
        return Island;

    }
    public int dfs(int row,int col,int[][] grid){
        int m =grid.length;
        int n=grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col]==0) return 0;
        grid[row][col]=0;
        return 1+dfs(row+1,col,grid)+dfs(row-1,col,grid)+dfs(row,col+1,grid)+dfs(row,col-1,grid);
        
    }
}