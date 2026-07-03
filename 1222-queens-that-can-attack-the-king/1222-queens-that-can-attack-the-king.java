class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> list = new ArrayList<>();
        boolean board[][]=new boolean[8][8];
        for(int[] rows:queens){
            board[rows[0]][rows[1]]=true;
        }
        int[][] directions={
            {1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1},
        };

        for(int[] dir:directions){
            solve(king[0]+dir[0],king[1]+dir[1],dir[0],dir[1],board,list);
        }
        return list;
    }

    public void solve(int r,int c,int x,int y,boolean board[][],List<List<Integer>> list){

        if(r<0 || r>=8 || c<0 || c>=8) return;

        if(board[r][c]){
            list.add(Arrays.asList(r,c));
            return;
        }
        solve(r+x,c+y,x,y,board,list);

    }
}
    

    
