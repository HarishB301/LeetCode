class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int first=lower(nums,target);
        List<Integer> list=new ArrayList<>();
        if(first==-1) return list;
        int last=upper(nums,target);
        for(int i=first;i<=last;i++){
            list.add(i);
        }
        return list;

    }

    int lower(int[] arr,int k){
                  int low=0,high=arr.length-1,ans=-1;
                  while(low<=high){
                      int mid=low+(high-low)/2;
                      if(arr[mid]==k){
                          ans=mid;
                          high=mid-1;
                      }else if(arr[mid]>k){
                          high=mid-1;
                      }else low=mid+1;
            }
         return ans;

    }
     int upper(int[] arr,int k){
                  int low=0,high=arr.length-1,ans=-1;
                  while(low<=high){
                      int mid=low+(high-low)/2;
                      if(arr[mid]==k){
                          ans=mid;
                          low=mid+1;
                      }else if(arr[mid]>k){
                          high=mid-1;
                      }else low=mid+1;
            }
         return ans;

    }
}