package ua.com.alevel;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.datatable.DataTableReq;
import ua.com.alevel.datatable.DataTableRes;
import ua.com.alevel.datatable.Order;
import ua.com.alevel.entity.Employee;

import java.util.HashMap;
import java.util.Map;

public class CriteriaApiTest {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    public void test() {
        System.out.println("CriteriaApiTest.test");

        DataTableReq req = new DataTableReq();
        req.setCurrentPage(1);
        req.setPageSize(10);
        req.setSort("age");
        req.setOrderBy(Order.ASC);

        Map<String, String> map = new HashMap<>();
        map.put("firstName", "a");
        map.put("age", "> 23");

        req.setFilters(map);

        DataTableRes<Employee> dataTableRes = employeeDao.findAll(req);

        System.out.println("dataTableRes = " + dataTableRes);
        for (Employee item : dataTableRes.getItems()) {
            System.out.println("item = " + item);
        }
    }
}
