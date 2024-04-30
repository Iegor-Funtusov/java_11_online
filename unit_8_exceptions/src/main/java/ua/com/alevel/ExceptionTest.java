package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest {

    public void test(String input) {
        try {
            formatToIntAndDivideAndPrint(input);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception");
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
//        catch (RuntimeException e) {
            // 1
//            if (e.toString().startsWith("java.lang.ArithmeticException:")) {
//                System.out.println("Arithmetic exception");
//            }
//            if (e.toString().startsWith("java.lang.NumberFormatException:")) {
//                System.out.println("Number format exception");
//            }
            // 2
//            if (e instanceof ArithmeticException) {
//                System.out.println("Arithmetic exception");
//            }
//            if (e instanceof NumberFormatException) {
//                System.out.println("Number format exception");
//            }
//        }
        System.out.println("finish");
    }

    private void formatToIntAndDivideAndPrint(String text) throws RuntimeException {
        int i = Integer.parseInt(text);
        System.out.println("i = " + i);
        int res = 10 / i;
        System.out.println("res = " + res);
    }

    public void createStudent() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please enter your name: ");
            String name = bf.readLine();
            System.out.println("Please enter your age: ");
            int age = Integer.parseInt(bf.readLine());
            Student student = new Student();
            student.setName(name);
            if (age > 18) {
                student.setAge(age);
            } else {
                throw new IllegalArgumentException("Age must be less than 18");
            }
            System.out.println("student = " + student);
        } catch (IOException e) {
            System.out.println("e = " + e);
        } catch (NumberFormatException e) {
            System.out.println("e : " + e);
        }
    }
}
