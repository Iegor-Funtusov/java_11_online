package ua.com.alevel;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

    public void test() {
//        String s = null;
//        System.out.println("s = " + s.toCharArray());

//        String string = a?.getB()?.getC()?.getString(); // kotlin style

//        String string = a.getB().getC().getString();
        String string = null;
        A a = new A();
        // old style
        B b = a.getB();
        if (b != null) {
            C c = b.getC();
            if (c != null) {
                string = c.getString();
                if (string == null) {
                    string = "empty";
                }
            }
        }
        System.out.println("string = " + string);

        // new style
        Optional<B> optionalB = Optional.ofNullable(a.getB());
        B b1 = optionalB.orElse(new B());
        Optional<C> optionalC = Optional.ofNullable(b1.getC());
        C c1 = optionalC.orElse(new C());
        String s = Optional.ofNullable(c1.getString()).orElse("empty");

        //        String string = of(a?.getB()?.getC()?.getString()).orElseGet("empty); // kotlin style
        String result = Optional.ofNullable(
                            Optional.ofNullable(
                                        Optional.ofNullable(a.getB()).orElse(new B()).getC()
                                ).orElse(new C())
                                .getString())
                .orElse("empty");

        System.out.println("result = " + result);
    }
}
