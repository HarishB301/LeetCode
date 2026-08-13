class Solution {
    public int numOfSubarrays(int[] arr, int k, int t) {
        int count=0;
        int i=0,j=0,sum=0;
        while(j<arr.length){
             sum+=arr[j];
             int avg = sum/k;
             if((j-i+1)==k){
                if( avg>=t){
                     count++;
                }
                sum-=arr[i];
                i++;
                  
             }
             j++;
        }

        return count;
    }
}