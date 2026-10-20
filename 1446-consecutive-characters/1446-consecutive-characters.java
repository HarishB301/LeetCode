class Solution {
    public int maxPower(String s) {
        int n=s.length();
        int maxi=1;
        int maxLen=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                maxi++;
            }
            else maxi=1;
            maxLen=Math.max(maxLen,maxi);
        }

        return maxLen;
    }
}