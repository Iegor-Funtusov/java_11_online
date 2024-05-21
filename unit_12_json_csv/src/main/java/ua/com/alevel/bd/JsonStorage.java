package ua.com.alevel.bd;

import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.DBUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class JsonStorage implements BDStorage {

    private static final String STUDENT_JSON = "students.json";

    private final List<Student> students = new ArrayList<>();
    private final List<Group> groups = new ArrayList<>();

    @Override
    public void createStudent(Student student) {
        readStudentsFromJson();
        student.setId(DBUtil.generateId(students));
        students.add(student);
        writeStudentsToJson();
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(String id) {

    }

    @Override
    public Optional<Student> findStudentById(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Student> findAllStudents() {
        readStudentsFromJson();
        return students;
    }

    @Override
    public void createGroup(Group group) {

    }

    @Override
    public void updateGroup(Group group) {

    }

    @Override
    public void deleteGroup(String id) {

    }

    @Override
    public Optional<Group> findGroupById(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Group> findAllGroups() {
        return List.of();
    }

    @Override
    public void addStudentToGroup(String groupId, String studentId) {

    }

    @Override
    public Collection<Group> getAllGroupsByStudent(String studentId) {
        return List.of();
    }

    private void readStudentsFromJson() {
        Gson gson = new Gson();
        try {
           Student[] array = gson.fromJson(new FileReader(STUDENT_JSON), Student[].class);
           if (ArrayUtils.isNotEmpty(array)) {
               students.clear();
               students.addAll(Arrays.asList(array));
           }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeStudentsToJson() {
        Gson gson = new Gson();
        String json = gson.toJson(students);
        try(FileWriter fileWriter = new FileWriter(STUDENT_JSON)) {
            fileWriter.write(json);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
