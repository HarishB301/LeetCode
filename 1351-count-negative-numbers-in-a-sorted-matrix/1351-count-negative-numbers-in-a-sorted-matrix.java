class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for (int arr[] : grid) {
            count +=( m - (floor(arr, m, 0)+1));
        }
        return count;
    }

    int floor(int arr[], int n, int target) {
        int low = 0, high = n - 1,ans=-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans=mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}