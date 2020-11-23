public class TwoSumII {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[] {start + 1, end + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
