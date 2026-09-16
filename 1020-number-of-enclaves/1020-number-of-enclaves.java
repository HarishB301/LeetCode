
class Solution {
    public boolean isValid(int r,int c,int m,int n){
        return r>=0 && r<m && c>=0 && c<n;
    }
    public void dfs(int row,int col,int m,int n,boolean[][] vis,int[][] grid,int[] dr,int dc[]){
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int r=row+dr[i];
            int c=col+dc[i];
            if(isValid(r,c,m,n) && !vis[r][c] && grid[r][c]==1){
                dfs(r,c,m,n,vis,grid,dr,dc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(row==0 || row==m-1 || col==0 || col==n-1){
                    if(!vis[row][col] && grid[row][col]==1){
                        dfs(row,col,m,n,vis,grid,dr,dc);
                    }
                }
            }
        }
        int enclaves=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(!vis[row][col] && grid[row][col]==1){
                    enclaves++;
                }  
            }
        }

        return enclaves;  
    }
}

