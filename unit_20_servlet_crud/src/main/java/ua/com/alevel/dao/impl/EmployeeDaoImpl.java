package ua.com.alevel.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import ua.com.alevel.config.JpaFactory;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.datatable.DataTableReq;
import ua.com.alevel.datatable.DataTableRes;
import ua.com.alevel.datatable.Order;
import ua.com.alevel.entity.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

    @Override
    public DataTableRes<Employee> findAll(DataTableReq req) {
        DataTableRes<Employee> res = new DataTableRes<>();
        res.setCurrentPage(req.getCurrentPage());
        res.setPageSize(req.getPageSize());
        res.setOrderBy(req.getOrderBy());
        res.setSort(req.getSort());

        int page = (req.getCurrentPage() - 1) * req.getPageSize();

        // criteria api
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();
        if (MapUtils.isNotEmpty(req.getFilters())) {
            req.getFilters().forEach((k, v) -> {
                Predicate predicate = null;
                switch (k) {
                    case "firstName", "lastName" -> predicate = criteriaBuilder.like(root.get(k), "%" + v + "%");
                    case "age" -> {
                        if (v.startsWith(">")) {
                            String value = v.substring(2);
                            predicate = criteriaBuilder.greaterThan(root.get(k), value);
                        } else if (v.startsWith("<")) {
                            String value = v.substring(2);
                            predicate = criteriaBuilder.lessThan(root.get(k), value);
                        } else {
                            predicate = criteriaBuilder.equal(root.get(k), v);
                        }
                    }
                }
                if (predicate != null) {
                    predicates.add(predicate);
                }
            });
        }
        if (CollectionUtils.isNotEmpty(predicates)) {
            criteriaQuery.where(predicates.toArray(new Predicate[0]));
        }

        if (req.getOrderBy().equals(Order.ASC)) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(req.getSort())));
        }
        if (req.getOrderBy().equals(Order.DESC)) {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(req.getSort())));
        }

        Collection<Employee> employees = em.createQuery(criteriaQuery)
                .setFirstResult(page)
                .setMaxResults(req.getPageSize())
                .getResultList();

        //old school
//        final StringBuilder query = new StringBuilder("select e from Employee e");
//        final StringBuilder filters = new StringBuilder(" where");
//        AtomicBoolean isPresentFirst = new AtomicBoolean(false);
//        if (MapUtils.isNotEmpty(req.getFilters())) {
//            req.getFilters().forEach((k, v) -> {
//                isPresentFirst.set(!filters.toString().equals(" where"));
//                if (k.equals("firstName")) {
//                    if (isPresentFirst.get()) {
//                        filters.append(" and e.firstName like '%").append(v).append("%'");
//                    } else {
//                        filters.append(" e.firstName like '%").append(v).append("%'");
//                    }
//                }
//                if (k.equals("lastName")) {
//                    if (isPresentFirst.get()) {
//                        filters.append(" and e.lastName like '%").append(v).append("%'");
//                    } else {
//                        filters.append(" e.lastName like '%").append(v).append("%'");
//                    }
//                }
//                if (k.equals("age")) {
//                    if (isPresentFirst.get()) {
//                        filters.append(" and e.age ").append(v);
//                    } else {
//                        filters.append("e.age > 25");
//                    }
//                }
//            });
//        }
//        String filter = filters.toString();
//        if (StringUtils.isNotBlank(filter)) {
//            query.append(filter);
//        }
//        query
//                .append(" order by e.")
//                .append(req.getSort())
//                .append(" ");
//        if (req.getOrderBy().equals(Order.ASC)) {
//            query.append("asc");
//        } else {
//            query.append("desc");
//        }
//        Collection<Employee> employees = em.
//                createQuery(query.toString(), Employee.class)
//                .setFirstResult(page)
//                .setMaxResults(req.getPageSize())
//                .getResultList();
        res.setTotalItems(employees.size());
        res.setItems(employees);
        return res;
    }
}
