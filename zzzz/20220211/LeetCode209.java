class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while(left <= right && right < nums.length) {
            int sum = 0;
            for(int i = left;i <= right;i++) {
                sum += nums[i];
            }
            if(sum >= target) {
                min = Math.min(min,right - left + 1);
                left++;
            } else {
                right++;
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
