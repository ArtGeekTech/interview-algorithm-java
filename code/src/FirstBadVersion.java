public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        int start = 1, end = n, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return isBadVersion(start) ? start : end;
    }

    // Fake func API
    private static boolean isBadVersion(int n) {
        return n % 2 == 0;
    }
}
