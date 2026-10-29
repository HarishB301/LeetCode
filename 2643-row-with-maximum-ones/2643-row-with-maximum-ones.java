class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max_ones=0,index=0;
        int m=mat.length,n=mat[0].length;
        for(int i=0;i<m;i++){
            int ones_count=0;
            for(int j=0;j<n;j++){
                ones_count+=mat[i][j];
            }
            if(ones_count>max_ones){
                max_ones=ones_count;
                index=i;
            }
        }

        return  new int[]{index,max_ones};

    }

   
}