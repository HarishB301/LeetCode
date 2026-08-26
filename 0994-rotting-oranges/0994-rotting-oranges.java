class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q =new LinkedList<>();
        int Ones_count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                     vis[i][j]=true;
                }else vis[i][j]=false;
                if(grid[i][j]==1) Ones_count++;
            }
        }
        int tm=0;
        int count=0;
        int[] Grows={-1,0,+1,0};
        int[] Gcols={0,+1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int tim=q.peek().time;
            q.remove();
            for(int i=0;i<4;i++){
                int Gr=row+Grows[i];
                int Gc=col+Gcols[i];
                tm=Math.max(tm,tim);
                if(Gr>=0 && Gr<n && Gc>=0 && Gc<m && !vis[Gr][Gc] && grid[Gr][Gc]==1){
                    q.add(new Pair(Gr,Gc,tim+1));
                    vis[Gr][Gc]=true;
                    count++;
                }
            }
        }
        if(count!=Ones_count) return -1;
        return tm;
    }
}