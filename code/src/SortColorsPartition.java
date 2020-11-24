import static agt.algo.Utils.swap;

public class SortColorsPartition {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        //  =0       =1        todo      =2
        //[0, p1] [p1+1, i-1] [i, p2-1] [p2, end]
        int p1 = -1, p2 = nums.length;
        for (int i = 0; i <= p2 - 1; i++) {
            if (nums[i] == 0) {
                swap(nums, ++p1, i);
            } else if (nums[i] == 2) {
                swap(nums, --p2, i--);
            }
        }
    }
}
