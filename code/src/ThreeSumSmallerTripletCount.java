import java.util.Arrays;

public class ThreeSumSmallerTripletCount {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        final int sz = nums.length;
        int count = 0;
        for (int i = 0; i < sz; i++) {
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }
}
