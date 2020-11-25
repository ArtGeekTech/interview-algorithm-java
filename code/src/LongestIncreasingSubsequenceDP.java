import java.util.Arrays;

public class LongestIncreasingSubsequenceDP {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        final int sz = nums.length;
        int[] dp = new int[sz];  // LIS ending with nums[i]
        Arrays.fill(dp, 1);
        int maxLen = 0;

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
