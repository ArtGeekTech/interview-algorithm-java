public class PeakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return -1;
    }
}
