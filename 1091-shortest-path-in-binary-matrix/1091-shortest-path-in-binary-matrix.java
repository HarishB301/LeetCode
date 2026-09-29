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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length; 
        if(grid[n-1][n-1]!=0 || grid[0][0]!=0) return -1;
        if(n==1) return 1;
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(0,0,1));
        grid[0][0] = 1;
        int[] dr={-1,1,0,0,-1,1,1,-1};
        int[] dc={0,0,-1,1,1,-1,1,-1};

        while(!q.isEmpty()){
            Pair node=q.poll();
            int r=node.r;
            int c=node.c;
            int d=node.d;
            for(int i=0;i<8;i++){
                 int row=dr[i]+r;
                 int col=dc[i]+c;
                  if(row==n-1 && col==n-1) return d+1;
                 if(row>=0 && row<n && col>=0 && col<n && grid[row][col]==0){
                    q.add(new Pair(row,col,d+1));
                    grid[row][col]=1;
                 }
            }
        }
        return -1;

    }
}