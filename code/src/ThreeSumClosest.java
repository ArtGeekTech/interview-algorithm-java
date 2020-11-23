import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        final int sz = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < sz; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return sum;
                }
                res = Math.abs(res - target) < Math.abs(sum - target) ? res : sum;
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
}
