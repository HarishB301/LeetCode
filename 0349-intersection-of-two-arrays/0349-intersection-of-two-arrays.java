class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> list = new HashSet<>();

        int i=0,j=0,k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]) i++;
            else{
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        int[] op =new int[list.size()];
        int ind=0;
       for(int num:list){
           op[ind]=num;
           ind++;  
       }

        return op;
    }
}