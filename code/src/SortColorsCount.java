public class SortColorsCount {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        final int sz = nums.length;
        int[] counts = new int[3];
        for (int num: nums) {
            counts[num]++;
        }

        int i = 0;
        for (int color = 0; color < 3; color++) {
            while (counts[color]-- > 0) {
                nums[i++] = color;
            }
        }
    }
}
