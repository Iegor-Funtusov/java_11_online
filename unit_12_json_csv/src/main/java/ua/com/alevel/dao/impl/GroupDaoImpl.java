package ua.com.alevel.dao.impl;

import ua.com.alevel.bd.BDStorage;
import ua.com.alevel.dao.GroupDao;
import ua.com.alevel.entity.Group;
import ua.com.alevel.factory.DBFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GroupDaoImpl implements GroupDao {

    private final BDStorage bdStorage = DBFactory.getInstance().getBdStorage();

    @Override
    public void create(Group entity) {
        bdStorage.createGroup(entity);
    }

    @Override
    public void update(Group entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<Group> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Group> findAll() {
        return bdStorage.findAllGroups();
    }

    @Override
    public void addStudentToGroup(String groupId, String studentId) {
        bdStorage.addStudentToGroup(groupId, studentId);
    }

    @Override
    public Collection<Group> getAllGroupsByStudent(String studentId) {
        return bdStorage.getAllGroupsByStudent(studentId);
    }
}
