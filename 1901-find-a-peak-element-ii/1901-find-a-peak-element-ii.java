class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0,high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int rowIndex=maxEle(mat,mid,n,m);
            int left=mid-1>=0 ? mat[rowIndex][mid-1]:-1;
            int right=mid+1<m ? mat[rowIndex][mid+1]:-1;
            int ele=mat[rowIndex][mid];
            if(ele>left && ele>right) return new int[]{rowIndex,mid};
            else if(ele<left) high=mid-1;
            else  low=mid+1;
        }
        return new int[]{-1,-1};
    }

    int maxEle(int arr[][],int mid,int n,int m){
        int max=Integer.MIN_VALUE,index=0;
        for(int i=0;i<n;i++){
             if(arr[i][mid]>max){
                max=arr[i][mid];
                index=i;
             }
        }
        return index;
    }
}