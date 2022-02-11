/**
 * 快慢指针法覆盖
 */
public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        int right = nums.length -1;
        int left = 0;
        int fast = left;
        while(fast <= right) {
            if(nums[fast] == val) {
                fast++;
            } else {
                nums[left++] = nums[fast++];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(removeElement(nums, 3));
    }
}
