package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import ua.com.alevel.config.JpaFactory;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.datatable.DataTableReq;
import ua.com.alevel.datatable.DataTableRes;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {

    private final EntityManager em = JpaFactory.getInstance().getEntityManager();
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void save(Department entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public void update(Department entity) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(Long id) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Query query = em.createQuery("delete from Employee e where e.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.ofNullable(em.find(Department.class, id));
    }

    @Override
    public Collection<Department> findAll() {
        return em.createQuery("select e from Department e", Department.class).getResultList();
    }

    @Override
    public DataTableRes<Department> findAll(DataTableReq req) {
        return null;
    }

    @Override
    public boolean existsByName(String departmentName) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Query query = em.createQuery("select d from Department d where d.name = :name")
                    .setParameter("name", departmentName);
            long count = (Long) query.getSingleResult();
            tx.commit();
            return count > 0;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return false;
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {
        Department department = this.findById(departmentId).orElseThrow(() -> new RuntimeException("department not found"));
        Employee employee = employeeDao.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not found"));
        Set<Employee> employees = department.getEmployees();
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
