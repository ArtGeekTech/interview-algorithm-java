package pgk1;

public class B implements Flyable {

//    public static abstract void foo();

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b = null;
        b.toString();
        System.out.println(b instanceof Flyable);
    }
}
