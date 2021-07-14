package agt.algo;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        List<String> list = Arrays.asList("a");
        List<Integer> list2 = Arrays.asList(1,3);
        list.add("b");



//        int num = Integer.parseInt("3456237490");
//        List.of("a");
        System.out.println(Integer.MAX_VALUE);
    }
}
