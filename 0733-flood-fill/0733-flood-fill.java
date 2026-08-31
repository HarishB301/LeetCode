class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int num=image[sr][sc];
        boolean[][] vis=new boolean[m][n];
        dfs(sr,sc,vis,image,color,n,m,num);
        return image;

    }
    public void dfs(int row,int col,boolean[][] vis,int[][] image,int color,int n,int m,int num){
        
        if(image[row][col]!=num){
            return;
        }
        vis[row][col]=true;
        image[row][col]=color;
        if(row+1<=m-1 && !vis[row+1][col]) dfs(row+1,col,vis,image,color,n,m,num);
        if(row-1>=0 &&!vis[row-1][col]) dfs(row-1,col,vis,image,color,n,m,num);
        if(col+1<=n-1 &&!vis[row][col+1]) dfs(row,col+1,vis,image,color,n,m,num);
        if(col-1>=0 && !vis[row][col-1]) dfs(row,col-1,vis,image,color,n,m,num);
    }
}