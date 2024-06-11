package ua.com.alevel.dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void createStudent(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        // declarative
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            session.update(student);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
        // hql
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(
                    "update Student s set s.age = :age, s.firstName =:firstName, s.lastName =:lastName where s.id = :id")
                    .setParameter("age", student.getAge())
                    .setParameter("firstName", student.getFirstName())
                    .setParameter("lastName", student.getLastName())
                    .setParameter("id", student.getId());
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteStudent(Long id) {
        // declarative
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            Optional<Student> student = getStudentById(id);
//            if (student.isPresent()) {
//                session.delete(student.get());
//            }
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
        // hql
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Student s where s.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        // declarative
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            Student student = session.get(Student.class, id);
//            transaction.commit();
//            return Optional.ofNullable(student);
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return Optional.empty();

        // hql
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s where s.id = :id")
                    .setParameter("id", id);
            Student student = (Student) query.getSingleResult();
            transaction.commit();
            return Optional.ofNullable(student);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Student> getAllStudents() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select s from Student s");
            List<Student> students = query.getResultList();
            transaction.commit();
            return students;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return List.of();
    }
}
