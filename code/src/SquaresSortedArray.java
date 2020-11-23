public class SquaresSortedArray {
    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        final int sz = nums.length;
        int[] res = new int[sz];
        int l = 0, r = sz - 1, i = sz - 1;
        while (l <= r) {
            int left = nums[l] * nums[l], right = nums[r] * nums[r];
            if (left >= right) {
                res[i--] = left;
                l++;
            } else {
                res[i--] = right;
                r--;
            }
        }
        return res;
    }
}
