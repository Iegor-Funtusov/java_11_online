package ua.com.alevel.test;

public class Test {
    protected int a = 10;

    public static final String HELLO_WORLD = "Hello World!";

    public Test() {}

    public Test(int a) {
        this.a = a;
    }

    public void test() {
        int a = 0;
        System.out.println("a = " + a);
        System.out.println("a = " + this.a);
    }

    public static void testStatic(final int b) {
        System.out.println("b = " + b);
    }
}
