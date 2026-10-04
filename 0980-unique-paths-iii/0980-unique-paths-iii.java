class Solution {
    public int uniquePathsIII(int[][] Grid) {
        int m=Grid.length;
        int n=Grid[0].length;
        int NonObstacles=0,r=0,c=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(Grid[row][col]!=-1){
                    NonObstacles++;
                }
                if(Grid[row][col]==1){
                    r=row;
                    c=col;
                }
               
            }
        }
       
        return matrix(r,c,m,n,Grid,NonObstacles);
    }
    public int matrix(int row,int col,int m,int n,int[][] Grid,int count){
        if(row<0 || row>=m || col<0 || col>=n || Grid[row][col]==-1) return 0;
        if(Grid[row][col]==2){
            return count==1 ? 1:0;
        } 
        int temp=Grid[row][col];
        Grid[row][col]=-1;
        count--;
        int left=matrix(row,col-1,m,n,Grid,count);
        int right=matrix(row,col+1,m,n,Grid,count);
        int up=matrix(row-1,col,m,n,Grid,count);
        int down=matrix(row+1,col,m,n,Grid,count);
        Grid[row][col]=temp;

        return left+right+up+down;
    }
}
    
