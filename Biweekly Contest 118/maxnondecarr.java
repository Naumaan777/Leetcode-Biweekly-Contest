// Find Maximum Non-decreasing Array Length

class maxnondecarr {
    // Method to find the maximum length of a non-decreasing subarray
    public int findMaximumLength(int[] nums) {
        // Get the length of the input array
        int n = nums.length;
        
        // Initialize a new ArrayList to store the prefix sum of the array
        List<Long> a = new ArrayList<>();
        
        // Add 0 as the first element of the prefix sum
        a.add(0L);
        
        // Calculate the prefix sum of the array
        for(int i=0; i<n; i++)
        {
            a.add((long)nums[i] + a.get(a.size()-1));
        }
        
        // Initialize two arrays to store the maximum index and the maximum length of a non-decreasing subarray
        int[] index = new int[n + 1];
        int[] dp = new int[n + 1];
        
        // Loop through each element in the array
        for (int i = 1; i <= n; ++i) {
            // Update the maximum index
            index[i] = Math.max(index[i], index[i - 1]);
            
            // Update the maximum length of a non-decreasing subarray
            dp[i] = dp[index[i]] + 1;
            
            // Initialize the left and right pointers for binary search, and the index of the maximum sum
            int l = i, r = n, ind = 0;
            
            // Binary search to find the maximum index such that the sum of the subarray is less than or equal to twice the sum of the previous subarray
            while (l <= r) 
            {
                int mid = (l + r) / 2;
                if (a.get(mid) - a.get(i) < a.get(i) - a.get(index[i])) 
                {
                    l = mid + 1;
                }
                else 
                {
                    ind = mid;
                    r = mid - 1;
                }
            }
            
            // Update the maximum index
            index[ind] = i;
        }
        
        // Return the maximum length of a non-decreasing subarray
        return dp[n];
    }
}

