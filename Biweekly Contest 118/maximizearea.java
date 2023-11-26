// Maximize Area of Square Hole in Grid

class maximizearea {
    // Method to maximize the area of a square hole in a grid
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Find the minimum of the maximum consecutive horizontal and vertical bars
        int x = Math.min(helper(hBars), helper(vBars));
        // Return the area of the square hole (side length squared)
        return x * x;
    }
    
    // Helper method to find the maximum number of consecutive bars
    static int helper(int[] nums) {
        // Sort the array of bar positions
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        // Initialize the previous bar position and length of consecutive bars
        for(int i = 0, prev = Integer.MIN_VALUE, len = 0; i < n; i++) {
            // If the current bar is next to the previous bar
            if (nums[i] == prev + 1) {
                // Increase the length of consecutive bars
                len++;
            } else {
                // Reset the length of consecutive bars
                len = 1;
            }
            // Update the previous bar position
            prev = nums[i];
            // Update the maximum length of consecutive bars
            result = Math.max(result, len);
        }
        // Return the maximum length of consecutive bars plus one (for the hole)
        return result + 1;
    }
}
