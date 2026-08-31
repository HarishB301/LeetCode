class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        int Grow[]={1,-1,0,0};
        int Gcol[]={0,0,1,-1};
        for(int i=0;i<m;i++){
           if(!vis[i][0] && board[i][0]=='O'){
                 dfs(i,0,vis,board,Grow,Gcol);
            }
            if(!vis[i][n-1] && board[i][n-1]=='O'){
                 dfs(i,n-1,vis,board,Grow,Gcol);
            }
        }
        for(int i=0;i<n;i++){
           if(!vis[0][i] && board[0][i]=='O'){
                 dfs(0,i,vis,board,Grow,Gcol);
            }
            if(!vis[m-1][i] && board[m-1][i]=='O'){
                 dfs(m-1,i,vis,board,Grow,Gcol);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        return;
    }

    public void dfs(int row,int col,boolean[][] vis,char[][] grid,int Grow[],int Gcol[]){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=true;
        for(int i=0;i<4;i++){
            int r=Grow[i]+row;
            int c=Gcol[i]+col;
             if(r>=0 && r<m && c>=0 && c<n && !vis[r][c] && grid[r][c]=='O'){

                dfs(r,c,vis,grid,Grow,Gcol);
             }
        }
    }
}