package ua.com.alevel.dao;

import ua.com.alevel.entity.Group;

import java.util.Collection;

public interface GroupDao extends CrudDao<Group> {

    void addStudentToGroup(String groupId, String studentId);
    Collection<Group> getAllGroupsByStudent(String studentId);
}
