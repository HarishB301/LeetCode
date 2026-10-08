class Solution {
    public List<Integer> getRow(int rowIndex) {
         List<Integer> list=new ArrayList<>();
         int n=rowIndex+1;
        int[][] tri=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0) tri[i][j]=1;
                else if(i==j) tri[i][j]=1;
                else if(i!=0){
                    tri[i][j]=tri[i-1][j-1]+tri[i-1][j];
                }

            }
        }
        for(int i=0;i<n;i++){
            list.add(tri[n-1][i]);
        }

        return list;
    }
}