import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9,3,4,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        final int sz = arr.length;
        int[] aux = new int[sz];
        msort(arr, 0, sz - 1, aux);
    }

    private static void msort(int[] arr, int start, int end, int[] aux) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        msort(arr, start, mid, aux);
        msort(arr, mid + 1, end, aux);
        merge(arr, start, mid, end, aux);
    }

    private static void merge(int[] arr, int start, int mid, int end, int[] aux) {
        for (int k = start; k <= end; k++) {
            aux[k] = arr[k];
        }
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (aux[i] < aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = aux[i++];
        }
        while (j <= end) {
            arr[k++] = aux[j++];
        }
    }
}
