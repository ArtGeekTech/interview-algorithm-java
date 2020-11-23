import java.util.Arrays;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] nums, int K) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1, sum = -1;
        while (start < end) {
            if (nums[start] + nums[end] < K) {
                sum = Math.max(sum, nums[start] + nums[end]);
                start++;
            } else {
                end--;
            }
        }
        return sum;
    }
}
