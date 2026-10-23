class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i=0,j=letters.length-1;
        int n=j;
        char ans=target;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(letters[mid]>target){
                ans=letters[mid];
                j=mid-1;
            }else i=mid+1;
        }
        return ans==target ? letters[0]:ans;
    }
}