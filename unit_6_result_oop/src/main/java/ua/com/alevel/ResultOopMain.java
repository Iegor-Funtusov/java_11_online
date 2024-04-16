package ua.com.alevel;

import ua.com.alevel.test.Test;

class ResultOopMain {
    public static void main(String[] args) {
//        Test test = new Test();
//        test.test();
//
//        test = new Test(100);
//        test.test();

//        Test.testStatic();

//        System.out.println(Test.HELLO_WORLD);

//        System.out.println(CarConst.AUDI);
//        System.out.println(CarEnum.AUDI);


        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();

        human1.setName("Jack");
        human2.setName("Jack");
        human3.setName("Jack");
        human3.setName("Bob");
        human3.setName("Jack");

        StringBuilder sb = new StringBuilder("123 world 567");
        sb.append(" fasdfas ");
        sb.append(" hdg ");
        sb.append(" daD ");

        String result = sb.toString();
        System.out.println("result = " + result);

        String before = "123 world 567";
        before = before + " fasdfas ";
        before = before + " hdg ";
        before = before + " daD ";
        System.out.println("before = " + before);
//        String before1 = new String("123 world 567");
//        String after = before.replaceAll("^[0-9]*", "number");
//        System.out.println("after = " + after);

        String after = before.substring(4, 9);
        System.out.println("after = " + after);



        String blank = " ";
        String empty = " ";

        System.out.println("empty = " + empty.isEmpty());
        System.out.println("blank = " + blank.isBlank());


        String text = "1234";
        boolean isNumber = text.matches("[0-9]*");
        System.out.println("isNumber = " + isNumber);


        String s = "   Hello world!";
        System.out.println("s = " + s);

        int l = s.indexOf("w");

        if (l >= 0) {
            System.out.println("l = " + l);
        }

        if (s.contains("w")) {
            System.out.println("k = " + s.contains("w"));
        }

        char c = s.charAt(9);
        System.out.println("c = " + c);

        String[] strings = s.trim().split(" ");
        for (String string : strings) {
            System.out.println("string = " + string);
        }

        boolean endsWith = s.endsWith("d");
        boolean startsWith = s
                .trim()
                .toLowerCase()
                .startsWith("h");
        System.out.println("endsWith = " + endsWith);
        System.out.println("startsWith = " + startsWith);



//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            System.out.println("aChar = " + aChar);
//        }
    }
}
