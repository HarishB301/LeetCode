class Solution {
    public int findCenter(int[][] arr) {
        return (arr[0][0]==arr[1][0] || arr[0][0]==arr[1][1]) ? arr[0][0] : arr[0][1];
    }
}