package ua.com.alevel;

public class AnonimClassTest {

    public void test() {
        MathSum mathSum1 = new MathSumImpl();
        int sum = mathSum1.sum(1, 2);
        System.out.println("sum = " + sum);

        MathSum mathSum2 = new MathSum() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        sum = mathSum2.sum(1, 2);
        System.out.println("sum = " + sum);

        MathSum mathSum3 = (a, b) -> a + b;
        sum = mathSum3.sum(1, 2);
        System.out.println("sum = " + sum);
    }
}
