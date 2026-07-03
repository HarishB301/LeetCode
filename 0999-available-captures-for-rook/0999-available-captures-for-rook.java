class Solution {
    public int numRookCaptures(char[][] board) {
        int[] pos=new int[2];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j]=='R'){
                    pos[0]=i;
                    pos[1]=j;
                    break;
                }
            }
        }
        int count=0;
        int[][] direct={
            {-1,0},{0,-1},{1,0},{0,1}
        };

        for(int[] dir:direct){
            count+=solve(board,dir[0]+pos[0],dir[1]+pos[1],dir[0],dir[1],count);
        }

        return count;
        
    }

    public int solve(char[][] board,int r,int c,int x,int y,int count){
        if(r<0 || r>=8 || c<0 || c>=8) return 0;

        if(board[r][c]=='B') return 0;
        else if(board[r][c]=='p'){            
            return 1;
        }

        return solve(board,r+x,c+y,x,y,count);
    }
}