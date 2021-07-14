import java.util.*;

public class Utils {
    public static <T> void printList(List<T> list) {
        System.out.println(list);
    }

    public static <T> void printLists(List<List<T>> lists) {
        for (List<T> list: lists) {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b");
        List<List<String>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list);
        printList(list);
        printLists(lists);
    }
}
