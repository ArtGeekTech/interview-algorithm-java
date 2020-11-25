public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
