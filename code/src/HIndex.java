import java.util.Arrays;

public class HIndex {

    public static int hIndex_sort(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        final int N = citations.length;
        for (int i = 0; i < N; i++) {
            if (citations[i] >= N - i) {
                return N - i;
            }
        }
        return 0;
    }

    public int hIndex_count(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        final int N = citations.length;
        int[] papers = new int[N + 1];
        for (int c: citations) {
            papers[Math.min(N, c)]++;
        }

        int h = N; // citation
        // find first h that, h paper has at least h citations
        for (int count = papers[N]; count < h; count += papers[h]) {
            h--;
        }
        return h;
    }
}
