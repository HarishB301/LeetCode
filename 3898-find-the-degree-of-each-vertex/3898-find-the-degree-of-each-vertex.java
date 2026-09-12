class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n=matrix.length;
        int[] deg=new int[n];
        Arrays.fill(deg,0);
        for(int i=0;i<n;i++){
              for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    deg[i]+=1;
                }
              }
        }
        return deg;
    }
}