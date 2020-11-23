public class TwoSumII {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[] {l + 1, r + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
