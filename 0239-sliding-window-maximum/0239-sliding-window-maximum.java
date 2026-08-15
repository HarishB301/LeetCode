class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<k) return new int[0];
        int[] arr = new int[nums.length-k+1];
 
        int j=0,i=0;
        Deque<Integer> d = new LinkedList<>();
        while(j<nums.length){
              if(d.size()==0) d.add(nums[j]);
              else{
                while(d.size()>0 && d.peekLast()<nums[j]) d.removeLast();
                d.add(nums[j]);
              }
             if((j-i+1)<k) j++;
             else if((j-i+1)==k){
              arr[i]=d.peek();
              if(nums[i]==d.peek()) d.removeFirst();
              i++;
              j++;

             }
           
        }

        return arr;

    }
}