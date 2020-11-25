import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceGreedy {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            int idx = binarySearchInsertPos(list, num);
            if (idx == list.size()) {
                list.add(num);
            } else {
                list.set(idx, num);
            }
        }
        return list.size();
    }

    private static int binarySearchInsertPos(List<Integer> list, int target) {
        final int sz = list.size();
        if (sz == 0 || list.get(0) > target) {
            return 0;
        }
        if (list.get(sz - 1) < target) {
            return sz;
        }

        int start = 0, end = sz - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < target) {
                start = mid;
            } else if (list.get(mid) > target) {
                end = mid;
            } else {
                return mid;
            }
        }

        return list.get(start) == target ? start : end;
    }
}
