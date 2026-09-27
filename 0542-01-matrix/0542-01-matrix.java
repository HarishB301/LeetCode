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
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res=new int[m][n];
        boolean[][] vis=new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int dr[]={-1,1,0,0};
        int dc[]={0,0,-1,1};
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int r=pair.r;
            int c=pair.c;
            int d=pair.d;
            res[r][c]=d;
            for(int i=0;i<4;i++){
                int row=dr[i]+r;
                int col=dc[i]+c;
                if(row>=0 && row<m && col>=0 && col<n){
                    if(!vis[row][col]){
                        vis[row][col]=true;
                        q.add(new Pair(row,col,d+1));
                    }
                }
            }
        }
        return res;

    
   
    }
}