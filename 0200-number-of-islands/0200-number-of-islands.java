class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                      dfs(i,j,visited,grid,m,n);
                      count++;
                }
            }
        return count;
    }

    public void dfs(int start,int end,boolean[][] visited,char[][] grid,int m,int n){
          visited[start][end]=true;
          if(start-1>=0 && !visited[start-1][end] && grid[start-1][end]=='1')
                dfs(start-1,end,visited,grid,m,n);
          if(start+1<=m-1 && !visited[start+1][end] && grid[start+1][end]=='1')
                 dfs(start+1,end,visited,grid,m,n);
          if(end-1>=0 && !visited[start][end-1] && grid[start][end-1]=='1')
                dfs(start,end-1,visited,grid,m,n);
          if(end+1<=n-1 && !visited[start][end+1] && grid[start][end+1]=='1')
                dfs(start,end+1,visited,grid,m,n);
          
          
    }
}