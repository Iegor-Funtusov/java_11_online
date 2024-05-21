package ua.com.alevel.bd;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.entity.StudentGroup;
import ua.com.alevel.util.DBUtil;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class CSVStorage implements BDStorage {

    private static final String STUDENT_CSV = "students.csv";
    private static final String GROUP_CSV = "groups.csv";
    private static final String STUDENT_GROUP_CSV = "students_groups.csv";

    private final List<Student> students = new ArrayList<>();
    private final List<Group> groups = new ArrayList<>();
    private final Set<StudentGroup> studentGroups = new HashSet<>();

    @Override
    public void createStudent(Student student) {
        readStudentsFromCSV();
        student.setId(DBUtil.generateId(students));
        students.add(student);
        writeStudentsToCSV();
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
        readStudentsFromCSV();
        return students;
    }

    @Override
    public void createGroup(Group group) {
        readGroupsFromCSV();
        group.setId(DBUtil.generateId(groups));
        groups.add(group);
        writeGroupsToCSV();
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
        readGroupsFromCSV();
        return groups;
    }

    @Override
    public void addStudentToGroup(String groupId, String studentId) {
        readStudentsFromCSV();
        readGroupsFromCSV();
        readStudentGroupFromCSV();

        boolean isExistedStudent = students.stream().anyMatch(student -> student.getId().equals(studentId));
        boolean isExistedGroup = groups.stream().anyMatch(group -> group.getId().equals(groupId));
        if (isExistedGroup && isExistedStudent) {
            StudentGroup studentGroup = new StudentGroup();
            studentGroup.setGroupId(groupId);
            studentGroup.setStudentId(studentId);
            studentGroups.add(studentGroup);
            writeStudentGroupToCSV();
        }
    }

    @Override
    public Collection<Group> getAllGroupsByStudent(String studentId) {
        readGroupsFromCSV();
        readStudentGroupFromCSV();
        List<String> groupIds = studentGroups
                .stream()
                .filter(studentGroup -> studentGroup.getStudentId().equals(studentId))
                .map(StudentGroup::getGroupId)
                .toList();

        List<Group> newGroups = new ArrayList<>();
        groups.forEach(group -> {
            if (groupIds.contains(group.getId())) {
                newGroups.add(group);
            }
        });

        return newGroups;
    }

    private void readStudentsFromCSV() {
        try(CSVReader reader = new CSVReader(new FileReader(STUDENT_CSV))) {
            students.clear();
            List<String[]> line = reader.readAll();
            line.forEach(strings -> {
                Student student = new Student();
                student.setId(strings[0]);
                student.setFirstName(strings[1]);
                student.setLastName(strings[2]);
                student.setAge(Integer.parseInt(strings[3]));
                students.add(student);
            });
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeStudentsToCSV() {
        try(CSVWriter writer = new CSVWriter(new FileWriter(STUDENT_CSV))) {
            List<String[]> line = new ArrayList<>();
            students.forEach(student -> {
                String[] strings = new String[]{
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        String.valueOf(student.getAge())
                };
                line.add(strings);
            });
            writer.writeAll(line);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void readGroupsFromCSV() {
        try(CSVReader reader = new CSVReader(new FileReader(GROUP_CSV))) {
            groups.clear();
            List<String[]> line = reader.readAll();
            line.forEach(strings -> {
                Group group = new Group();
                group.setId(strings[0]);
                group.setName(strings[1]);
                groups.add(group);
            });
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeGroupsToCSV() {
        try(CSVWriter writer = new CSVWriter(new FileWriter(GROUP_CSV))) {
            List<String[]> line = new ArrayList<>();
            groups.forEach(group -> {
                String[] strings = new String[]{
                        group.getId(),
                        group.getName()
                };
                line.add(strings);
            });
            writer.writeAll(line);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void readStudentGroupFromCSV() {
        try(CSVReader reader = new CSVReader(new FileReader(STUDENT_GROUP_CSV))) {
            studentGroups.clear();
            List<String[]> line = reader.readAll();
            line.forEach(strings -> {
                StudentGroup studentGroup = new StudentGroup();
                studentGroup.setStudentId(strings[0]);
                studentGroup.setGroupId(strings[1]);
                studentGroups.add(studentGroup);
            });
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeStudentGroupToCSV() {
        try(CSVWriter writer = new CSVWriter(new FileWriter(STUDENT_GROUP_CSV))) {
            List<String[]> line = new ArrayList<>();
            studentGroups.forEach(group -> {
                String[] strings = new String[]{
                        group.getStudentId(),
                        group.getGroupId()
                };
                line.add(strings);
            });
            writer.writeAll(line);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
