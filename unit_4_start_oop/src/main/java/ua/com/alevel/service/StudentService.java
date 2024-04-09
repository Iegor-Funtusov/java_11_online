package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

// C - create
// R - read
// U - update
// D - delete
public class StudentService {

    private Student[] students = new Student[10];

    public void createStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                student.setId(i + 1);
                students[i] = student;
                break;
            }
        }
    }

    public void updateStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == student.getId()) {
                    students[i] = student;
                }
            }
        }
    }

    public void deleteStudent(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    students[i] = null;
                }
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }
}
