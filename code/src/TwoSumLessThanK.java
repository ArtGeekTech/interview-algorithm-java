import java.util.Arrays;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] nums, int K) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1, sum = -1;
        while (l < r) {
            if (nums[l] + nums[r] < K) {
                sum = Math.max(sum, nums[l] + nums[r]);
                l++;
            } else {
                r--;
            }
        }
        return sum;
    }
}
