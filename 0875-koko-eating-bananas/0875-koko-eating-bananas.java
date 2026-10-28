class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int ele:piles) max=Math.max(max,ele);
        int n=piles.length;
        long high=(long)max,low=1,ans=Integer.MAX_VALUE;
        while(low<=high){
            long mid=low+(high-low)/2;
            long totalhrs=fun(piles,mid);
            if(totalhrs<=h){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return (int)low;

    }

    public long fun(int[] piles,long h){
        long totalhrs=0;
        for(int ele:piles){
            totalhrs+=(ele+h-1)/h;
        }
        return totalhrs;
    }
}