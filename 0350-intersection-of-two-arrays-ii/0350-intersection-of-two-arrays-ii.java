class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

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
        while(k<list.size()){
            op[k]=list.get(k);
            k++;
        }

        return op;
    }
}