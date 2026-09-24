class Solution {
    
    public int islandPerimeter(int[][] grid) {
        int  m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,vis,grid);
                }
            }
        }
        return 0;
    }
    private int dfs(int row,int col,boolean[][] vis,int[][] grid){
        
         int  m=grid.length;
         int n=grid[0].length;
         if(row<0 || col<0 || row>=m || col>=n) return 1;
         if(vis[row][col]) return 0;
         if(grid[row][col]==0) return 1;
        
         int[] dr={-1,1,0,0};
         int[] dc={0,0,-1,1};
          vis[row][col]=true;
         int perimeter=0;
         for(int i=0;i<4;i++){
            int r=row+dr[i];
            int c=col+dc[i];
                perimeter+=dfs(r,c,vis,grid);
            
            
         }
         return perimeter;
    }
    
    
}