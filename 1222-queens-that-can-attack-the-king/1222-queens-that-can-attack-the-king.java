class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> list = new ArrayList<>();
        boolean board[][]=new boolean[8][8];
        for(int[] rows:queens){
            board[rows[0]][rows[1]]=true;
        }
        solve(list,board,king);
        return list;
    }

    public void solve(List<List<Integer>> list,boolean board[][],int[] king){
       
        for(int x=-1;x<=1;x++){
            for(int y=-1;y<=1;y++){
                if(x==0 && y==0) continue;
                int row=king[0];
                int col=king[1];
                while(row+x >-1 && col+y >-1 && row+x<8 && col+y<8){
                     row+=x;
                     col+=y;
                     if(board[row][col]){
                        List<Integer> res = new ArrayList<>();
                        res.add(row);
                        res.add(col);   
                        list.add(res);
                        break;                 
                     }
                    }
                }
           }
      }

    }
    

    
