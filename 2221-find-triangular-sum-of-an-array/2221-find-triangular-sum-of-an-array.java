class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        int[][] m=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0) m[i][j]=nums[j];
                else if(j<n-1){
                    int num=m[i-1][j]+m[i-1][j+1];
                    m[i][j]=num%10;
                }
            }
        }
        return m[n-1][0];
    }
}