import java.util.Arrays;

public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] nums, int K) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int sum = -1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] < K) {
                sum = Math.max(sum, nums[lo] + nums[hi]);
                lo++;
            } else {
                hi--;
            }
        }
        return sum;
    }
}
