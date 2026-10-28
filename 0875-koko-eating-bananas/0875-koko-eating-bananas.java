class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
        long high=(long)piles[n-1],low=1,ans=Integer.MAX_VALUE;
        while(low<=high){
            long mid=low+(high-low)/2;
            long totalhrs=fun(piles,mid);
            if(totalhrs<=h){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return (int)ans;

    }

    public long fun(int[] piles,long h){
        long totalhrs=0;
        for(int ele:piles){
            totalhrs+=(ele+h-1)/h;
        }
        return totalhrs;
    }
}