import java.util.Arrays;

public class ThreeSumSmallerTripletCount {

    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        final int sz = nums.length;
        int count = 0;
        for (int i = 0; i < sz; i++) {
            int start = i + 1, end = sz - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
