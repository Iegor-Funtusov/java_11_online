package ua.com.alevel.dao;

import ua.com.alevel.db.DbStudent;
import ua.com.alevel.entity.Student;

public class StudentDao {

    private DbStudent dbStudent = new DbStudent();

    public void createStudent(Student student) {
        dbStudent.createStudent(student);
    }

    public void updateStudent(Student student) {
        dbStudent.updateStudent(student);
    }

    public void deleteStudent(int id) {
        dbStudent.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return dbStudent.getStudentById(id);
    }

    public Student[] getAllStudents() {
        Student[] students = dbStudent.getStudents();
        int countOfNotNullStudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                countOfNotNullStudents++;
            }
        }
        Student[] newStudents = new Student[countOfNotNullStudents];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                for (int j = 0; j < countOfNotNullStudents; j++) {
                    if (newStudents[j] == null) {
                        newStudents[j] = students[i];
                        break;
                    }
                }
            }
        }
        return newStudents;
    }
}
