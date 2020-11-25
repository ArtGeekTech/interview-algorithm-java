package pgk1;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.set(0, 3);
        System.out.println(l1.get(0));


        InnerA a = new InnerA();
        System.out.println(a.innerA2);
        String s3 = new String("pool");
        String s1 = "pool";
        String s2 = "pool";

//        String s3 = new String("pool");
        String s33 = new String("pool");
        String s4 = String.valueOf("pool");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s33 == s3);
        System.out.println(s1 == s4);
//        System.out.println(a.innerA);
    }
}

class InnerA {
    private int innerA;
    int innerA2;
}