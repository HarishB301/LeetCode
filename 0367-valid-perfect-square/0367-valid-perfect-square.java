class Solution {
    public boolean isPerfectSquare(int num) {
        long low=1,high=num;
        while(low<=high){
            long mid=low+(high-low)/2;
            long square=mid*mid;
            if(square==(long)num) return true;
            else if(square>(long)num) high=mid-1;
            else low=mid+1;
        }
        return false;
       
    }
}