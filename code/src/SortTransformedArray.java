public class SortTransformedArray {

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        final int sz = nums.length;
        int[] res = new int[sz];
        if (a == 0) {
            if (b >= 0) {
                for(int i = 0; i < sz; i++) {
                    res[i] = func(nums[i], a, b, c);
                }
            } else {
                for(int i = 0; i < sz; i++) {
                    res[sz - 1 - i] = func(nums[i], a, b, c);
                }
            }
        } else if (a > 0) {
            int l = 0, r = sz - 1, i = sz - 1;
            while (l <= r) {
                int left = func(nums[l], a, b, c), right = func(nums[r], a, b, c);
                if (left > right) {
                    res[i--] = left;
                    l++;
                } else {
                    res[i--] = right;
                    r--;
                }
            }
        } else {
            int l = 0, r = sz - 1, i = 0;
            while (l <= r) {
                int left = func(nums[l], a, b, c), right = func(nums[r], a, b, c);
                if (left < right) {
                    res[i++] = left;
                    l++;
                } else {
                    res[i++] = right;
                    r--;
                }
            }
        }

        return res;
    }

    private static int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
