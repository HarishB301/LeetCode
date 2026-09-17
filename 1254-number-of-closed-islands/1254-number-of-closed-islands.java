class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int islands=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    if(dfs(row,col,grid)) islands++;
                }
            }
        }
        return islands;
    }
    public boolean dfs(int row,int col,int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        if(row>=m || row<0 || col>=n || col<0) return false;
        if(grid[row][col]==1) return true;
        grid[row][col]=1;
        boolean left=dfs(row,col-1,grid);
        boolean right=dfs(row+1,col,grid);
        boolean up=dfs(row,col+1,grid);
        boolean down=dfs(row-1,col,grid);
        return left && right && up && down;
    }
}