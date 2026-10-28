class Solution {
    public int splitArray(int[] arr, int k) {
      	int n = arr.length;
		if (k>n)
			return - 1;
		
		int high = 0, low = 0;
		for (int i = 0; i<n; i++) {
			low = Math.max(low, arr[i]);
			high += arr[i];
		}
		while (low <= high) {
			int mid = low + (high - low)/2;
			int painters = fun(arr, mid, k);
			if (painters>k) {
				low = mid + 1;
			} else high = mid - 1;
		}
		return low;
		
	}
	
	int fun(int[] arr, int pages, int k) {
		int painters = 1, units = 0;
		for (int i = 0; i<arr.length; i++) {
			if (units + arr[i] <= pages) {
				units += arr[i];
			}
			else {
				painters++;
				units = arr[i];
			}
		}
		
		return painters;
	}  
    
}