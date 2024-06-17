package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import ua.com.alevel.config.JpaFactory;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager em = JpaFactory.getInstance().getEntityManager();

    @Override
    public void save(Employee entity) {
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
    public void update(Employee entity) {
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
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    @Override
    public Collection<Employee> findAll() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
