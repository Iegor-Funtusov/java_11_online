package ua.com.alevel.pointer;

import ua.com.alevel.db.ListStudentDao;
import ua.com.alevel.db.StudentDao;
import ua.com.alevel.entity.Student;

import java.util.Arrays;
import java.util.List;

public class PointerToMethod {

    private final StudentDao studentDao = new ListStudentDao();

    private int a;

    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // pointer 1
        // link to the current method of class
        sum = list.stream().reduce(0, (a, b) -> sum(a, b));
        sum = list.stream().reduce(0, (a, b) -> this.sum(a, b));
        sum = list.stream().reduce(0, this::sum);

        // pointer 2
        // link to the static method of another class
        sum = list.stream().reduce(0, (a, b) -> sum(a, b));
        sum = list.stream().reduce(0, MathUtil::sum);

        // pointer 3
        // link to the method of variable
        sum = list.stream().reduce(0, (a, b) -> sum(a, b));
        MathClass mathClass = new MathClass();
        sum = list.stream().reduce(0, mathClass::sum);

        // pointer 4
        // link to the constructor
        Student student1 = new Student("aa", "aaa", 20);
        Student student2 = new Student("ww", "www", 20);
        Student student3 = new Student("ee", "eee", 20);

        List<Student> students = Arrays.asList(student1, student2, student3);
        List<StudentData> studentDataList = students
                .stream()
//                .map(student -> new StudentData(student))
                .map(StudentData::new)
                .toList();

        studentDataList.forEach(System.out::println);
//        List<StudentData> studentDataList = students
//                .stream()
//                .map(student -> {
////                    StudentData studentData = new StudentData();
////                    studentData.setId(student.getId());
////                    studentData.setFirstName(student.getFirstName());
////                    studentData.setLastName(student.getLastName());
////                    studentData.setAge(student.getAge());
////                    return studentData;
//
//                    return new StudentData(
//                            student.getId(),
//                            student.getFirstName(),
//                            student.getLastName(),
//                            student.getAge()
//                    );
//                })
//                .toList();
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
