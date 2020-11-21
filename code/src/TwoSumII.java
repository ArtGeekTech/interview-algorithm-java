public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("No two sum solution");
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[] {lo + 1, hi + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
