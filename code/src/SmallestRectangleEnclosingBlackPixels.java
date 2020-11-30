public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }

        final int row = image.length, col = image[0].length;
        int left = binarySearchBound(image, 0, y, true, true);
        int right = binarySearchBound(image, y, col - 1, true, false);
        int up = binarySearchBound(image, 0, x, false, true);
        int down = binarySearchBound(image, x, row - 1, false, false);
        return (right - left + 1) * (down - up + 1);
    }

    private int binarySearchBound(char[][] image, int start, int end, boolean isCol, boolean endIsBlack) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, mid, isCol)) {
                if (endIsBlack) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (endIsBlack) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (endIsBlack) {
            return hasBlack(image, start, isCol) ? start : end;
        } else {
            return hasBlack(image, end, isCol) ? end : start;
        }
    }

    private boolean hasBlack(char[][] image, int idx, boolean isCol) {
        final int row = image.length, col = image[0].length;
        if (isCol) {
            for (int i = 0; i < row; i++) {
                if (image[i][idx] == '1') {
                    return true;
                }
            }
        } else {
            for (int j = 0; j < col; j++) {
                if (image[idx][j] == '1') {
                    return true;
                }
            }
        }
        return false;
    }
}
