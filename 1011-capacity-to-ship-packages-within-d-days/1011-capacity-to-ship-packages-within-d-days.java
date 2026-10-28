class Solution {
    public int shipWithinDays(int[] w, int days) {
        int n=w.length;
        int low=1,high=0;
        for(int ele:w){
            low=Math.max(low,ele);
            high+=ele;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean Mindays=fun(w,mid,days);
            if(Mindays) high=mid-1;
            else low=mid+1;
        }
        return low;
    }

    public boolean fun(int[] w,int mid,int days){
        int noOfdays=1,capacity=0;
        for(int ele:w){
            if(capacity+ele>mid){
                noOfdays++;
                capacity=0;
            }
            capacity+=ele;
          
        }

        return noOfdays<=days;
    }
}