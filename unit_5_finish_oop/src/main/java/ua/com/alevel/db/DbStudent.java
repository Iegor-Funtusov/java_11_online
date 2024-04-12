package ua.com.alevel.db;

import ua.com.alevel.entity.Student;

public class DbStudent {

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

    public Student getStudentById(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getId() == id) {
                    return students[i];
                }
            }
        }
        return null;
    }

    public Student[] getStudents() {
        return students;
    }
}
