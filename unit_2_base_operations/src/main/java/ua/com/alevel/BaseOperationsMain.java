package ua.com.alevel;

public class BaseOperationsMain {
    public static void main(String[] args) {
        // primitive

        // number

        // 1b
        byte bMax = Byte.MAX_VALUE;
        byte bMin = Byte.MIN_VALUE;
        System.out.println("bMin = " + bMin);
        System.out.println("bMax = " + bMax);

        // 2b
        short sMax = Short.MAX_VALUE;
        short sMin = Short.MIN_VALUE;
        System.out.println("sMin = " + sMin);
        System.out.println("sMax = " + sMax);

        // 4b
        int iMax = Integer.MAX_VALUE;
        int iMin = Integer.MIN_VALUE;
        System.out.println("iMin = " + iMin);
        System.out.println("iMax = " + iMax);

        // 8b
        long lMax = Long.MAX_VALUE;
        long lMin = Long.MIN_VALUE;
        System.out.println("lMin = " + lMin);
        System.out.println("lMax = " + lMax);

        // 4b
        float fMax = Float.MAX_VALUE;
        float fMin = Float.MIN_VALUE;
        System.out.println("fMin = " + fMin);
        System.out.println("fMax = " + fMax);

        // 8b
        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;
        System.out.println("dMin = " + dMin);
        System.out.println("dMax = " + dMax);

        int a = 1;
        int b = 2;
        int sum = a + b;
        int nextInt = a + iMax;
        System.out.println("sum = " + sum);
        System.out.println("nextInt = " + nextInt);

        System.out.println(a - b);
        System.out.println(a / b);
        System.out.println(a * b);

        // character
        // 2b
        char c = 'a';
        System.out.println("c = " + c);
        System.out.println("c = " + (int) c);

        // boolean
        // 1b
        boolean bool = false;
        System.out.println("bool = " + bool);

        // reference

        char i = 'I';
        char e = 'e';
        char h = 'h';
        char o = 'o';
        char r = 'r';
        System.out.print(i);
        System.out.print(e);
        System.out.print(h);
        System.out.print(o);
        System.out.print(r);

        System.out.println();

        char[] nameOfIehor = new char[5];
        nameOfIehor[0] = 'I';
        nameOfIehor[1] = 'e';
        nameOfIehor[2] = 'h';
        nameOfIehor[3] = 'o';
        nameOfIehor[4] = 'r';
        for (int j = 0; j < nameOfIehor.length; j++) {
            System.out.print(nameOfIehor[j]);
        }
        System.out.println();

        char[] noi = new char[]{ 'I', 'e', 'h', 'o', 'r' };
        for (char c1 : noi) {
            System.out.print(c1);
        }

        String name = "Iehor";
        System.out.println("name = " + name);
    }
}
