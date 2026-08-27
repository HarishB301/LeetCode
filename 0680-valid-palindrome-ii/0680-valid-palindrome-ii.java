class Solution {
    public boolean validPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1==ch2){
                i++;
                j--;
            }else{
                return palindrome(s,i+1,j) || palindrome(s,i,j-1);
            }
            
        }
        return true;
        
    }

    private boolean palindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }
}