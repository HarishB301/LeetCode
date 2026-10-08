class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
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
            for(int j=0;j<=i;j++){
                list.get(i).add(tri[i][j]);
            }
        }

        return list;
    }
}