public class HIndexII {

    public static int hIndex(int[] citations) {
        if (citations== null || citations.length == 0) {
            return 0;
        }

        final int N = citations.length;
        int start = 0, end = N - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // at least h cite     h paper
            if (citations[mid] > N - mid) {
                end = mid;
            } else if (citations[mid] < N - mid) {
                start = mid;
            } else {
                return N - mid;
            }
        }

        if (citations[start] >= N - start) {
            return N - start;
        }
        if (citations[end] >= N - end) {
            return N - end;
        }
        return 0;
    }
}
