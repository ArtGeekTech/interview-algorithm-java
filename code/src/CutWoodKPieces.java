import static agt.algo.Utils.getMax;

public class CutWoodKPieces {
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int start = 1, end = getMax(L);
        if (cutWood(L, end) >= k) {
            return end;
        }
        if (cutWood(L, start) < k) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (cutWood(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return cutWood(L, end) >= k ? end : start;
    }

    private long cutWood(int[] L, int maxLen) {
        long count = 0;
        for (int len: L) {
            count += len / maxLen;
        }
        return count;
    }
}
