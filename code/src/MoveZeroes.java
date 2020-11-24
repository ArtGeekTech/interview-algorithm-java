import java.util.Arrays;

import static agt.algo.Utils.swap;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        //[0, p] [p+1, i-1] [i, sz-1]
        final int sz = nums.length;
        int p = -1;
        for (int i = 0; i < sz; i++) {
            if (nums[i] != 0) {
                swap(nums, ++p, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,2,0,0,1,3,9};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
