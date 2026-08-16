class Solution {
    public int largestAltitude(int[] gain) {
        int alt=0,maxAlt=0;
        for(int g:gain){
            alt+=g;
            maxAlt=Math.max(alt,maxAlt);
        }
        return maxAlt;
    }
}