package ua.com.alevel.view;

import ua.com.alevel.dao.GroupDao;
import ua.com.alevel.dao.impl.GroupDaoImpl;
import ua.com.alevel.entity.Group;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public class GroupView {

    private final GroupDao groupDao = new GroupDaoImpl();

    public void start(BufferedReader reader) throws IOException {
        System.out.println("Welcome to group view!");
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            if (text.equals("8")) {
                return;
            }
            goToOperations(text, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println("If you want create group please enter 1");
        System.out.println("If you want find all group please enter 2");
        System.out.println("If you want find by id group please enter 3");
        System.out.println("If you want update group please enter 4");
        System.out.println("If you want delete group please enter 5");
        System.out.println("If you want attach student to group please enter 6");
        System.out.println("If you want review all groups by student please enter 7");
        System.out.println("If you want exit please enter 8");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> createGroup(reader);
            case "2" -> getGroups();
            case "3" -> findGroup(reader);
            case "4" -> updateGroup(reader);
            case "5" -> deleteGroup(reader);
            case "6" -> addStudentToGroup(reader);
            case "7" -> getAllGroupsByStudent(reader);
        }
    }

    private void getAllGroupsByStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the student id");
        String studentId = reader.readLine();
        Collection<Group> groups = groupDao.getAllGroupsByStudent(studentId);
        for (Group group : groups) {
            System.out.println("Id " + group.getId());
            System.out.println("Name " + group.getName());
        }
    }

    private void createGroup(BufferedReader reader) throws IOException {
        System.out.println("Please enter the name of the group");
        String name = reader.readLine();

        Group group = new Group();
        group.setName(name);

        groupDao.create(group);
    }

    private void updateGroup(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the group");
        String id = reader.readLine();
        System.out.println("Please enter the name of the group");
        String name = reader.readLine();

        Group group = new Group();
        group.setId(id);
        group.setName(name);

        groupDao.update(group);
    }

    private void findGroup(BufferedReader reader) throws IOException {
        System.out.println("Please enter id of the group");
        String id = reader.readLine();

        Optional<Group> optionalGroup = groupDao.findById(id);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            System.out.println("Id " + group.getId());
            System.out.println("Name " + group.getName());
        } else {
            System.out.println("Group not found by id " + id);
        }
    }

    private void deleteGroup(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the group you would like to delete");
        String id = reader.readLine();
        groupDao.delete(id);
    }

    private void addStudentToGroup(BufferedReader reader) throws IOException {
        System.out.println("Please enter the group id");
        String groupId = reader.readLine();
        System.out.println("Please enter the student id");
        String studentId = reader.readLine();
        groupDao.addStudentToGroup(groupId, studentId);
    }

    private void getGroups() {
        Collection<Group> groups = groupDao.findAll();
        for (Group group : groups) {
            System.out.println("Id " + group.getId());
            System.out.println("Name " + group.getName());
        }
    }
}
