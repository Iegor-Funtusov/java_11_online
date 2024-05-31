package ua.com.alevel;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Student;

import java.util.Random;
import java.util.UUID;

public class GenerateStudent {

    private final StudentDao studentDao = new StudentDaoImpl();

    public void generateStudent() {
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setFirstName(UUID.randomUUID().toString());
            student.setLastName(UUID.randomUUID().toString());
            student.setAge(new Random().nextInt(20, 40));
            studentDao.createStudent(student);
        }
    }

    public void testDao() {
        double avg = studentDao.averageOfAge();
        System.out.println("avg = " + avg);
        int sum = studentDao.sumOfAge();
        System.out.println("sum = " + sum);
    }
}
