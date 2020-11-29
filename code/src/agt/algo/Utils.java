package agt.algo;

public class Utils {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int getMax(int[] nums) {
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
