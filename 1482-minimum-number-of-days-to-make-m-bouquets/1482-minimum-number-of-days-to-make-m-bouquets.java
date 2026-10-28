class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n=arr.length;
        if(m*k>n) return -1;
        int low=Integer.MAX_VALUE,high=Integer.MIN_VALUE,ans=-1;
        for(int ele:arr){
            low=Math.min(low,ele);
            high=Math.max(high,ele);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(fun(arr,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;

    }

    public boolean fun(int[] arr,int m,int k,int mid){
        int mCount=0,kCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=mid){
                kCount++;
            }else{
               mCount+=(kCount/k);
               kCount=0;
            }
        }
        mCount+=(kCount)/k;
        return mCount>=m;
    }
}