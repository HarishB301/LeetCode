class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int nearestExit(char[][] maze, int[] e) {
        int n=maze.length;
        int m=maze[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(e[0],e[1],0));
        int drow[]={1,-1,0,0};
        int dcol[]={0,0,-1,1};
        int count=-1;
        maze[e[0]][e[1]]='+';
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.r;
            int c=p.c;
            int d=p.d;
            for(int i=0;i<4;i++){
                int row=r+drow[i];
                int col=c+dcol[i];
                if(row>=0 && row<n && col>=0 && col<m && maze[row][col]=='.'){
                    if(row==0 || row==n-1 || col==0 || col==m-1){
                        return d+1;
                    }
                    maze[row][col]='+';
                    q.add(new Pair(row,col,d+1));
                }
            }

        }
        return -1;


    }
}