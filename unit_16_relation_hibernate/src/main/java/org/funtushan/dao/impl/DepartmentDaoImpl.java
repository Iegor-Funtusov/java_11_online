package org.funtushan.dao.impl;

import jakarta.persistence.Query;
import org.apache.commons.collections4.CollectionUtils;
import org.funtushan.config.HibernateConfig;
import org.funtushan.dao.DepartmentDao;
import org.funtushan.dao.EmployeeDao;
import org.funtushan.entity.Department;
import org.funtushan.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void save(Department entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Department entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete from Department d where d.id = :id")
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
    public Optional<Department> findById(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            transaction.commit();
            return Optional.ofNullable(department);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Department> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select d from Department d");
            List<Department> departments = query.getResultList();
            transaction.commit();
            return departments;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return List.of();
    }

    @Override
    public boolean existsByName(String departmentName) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select count(d) from Department d where d.name = :name")
                    .setParameter("name", departmentName);
            long count = (Long) query.getSingleResult();
            transaction.commit();
            return count > 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {
        Department department = this.findById(departmentId).orElseThrow(() -> new RuntimeException("department not found"));
        Employee employee = employeeDao.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not found"));
        Set<Employee> employees = department.getEmployees();
//        department.getEmployees().add(employee);
        employees.add(employee);
        this.update(department);
    }

    @Override
    public void detachEmployeeToDepartment(Long departmentId, Long employeeId) {
        Department department = this.findById(departmentId).orElseThrow(() -> new RuntimeException("department not found"));
        Employee employee = employeeDao.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not found"));
        Set<Employee> employees = department.getEmployees();
        employees.removeIf(e -> e.getId().equals(employee.getId()));
        this.update(department);
    }
}
