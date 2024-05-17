package ua.com.alevel.bd;

import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface BDStorage {
    
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(String id);
    Optional<Student> findStudentById(String id);
    Collection<Student> findAllStudents();

    void createGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(String id);
    Optional<Group> findGroupById(String id);
    Collection<Group> findAllGroups();

    void addStudentToGroup(String groupId, String studentId);
    Collection<Group> getAllGroupsByStudent(String studentId);
}
