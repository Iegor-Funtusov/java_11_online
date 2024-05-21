package ua.com.alevel.serial;

import java.io.*;
import java.util.UUID;

public class SerialTest {

    private Student student;

    public void test() {
        init();
        serialize(student);
        deserialize();
    }

    private void serialize(Student student) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deserialize() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            student = (Student) ois.readObject();
            System.out.println("student = " + student);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Student init() {
        student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setFirstName("John");
        student.setLastName("Doe");
        student.setFullName("John Doe");
        return student;
    }
}
