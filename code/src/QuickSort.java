import static agt.algo.Utils.swap;

public class QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(arr, start, end);
        qsort(arr, start, p - 1);
        qsort(arr, p + 1, end);
    }

    // choose arr[end] as pivot around which to partition the subarray
    // [start, p] (<pivot) + [p+1, i-1] (>=pivot) + [i, end-1] (todo)
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end], p = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (arr[i] < pivot) {
                swap(arr, ++p, i);
            }
        }
        swap(arr, ++p, end);
        return p;
    }


}
