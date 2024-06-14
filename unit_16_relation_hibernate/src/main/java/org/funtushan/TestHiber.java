package org.funtushan;

import org.funtushan.service.DepartmentService;
import org.funtushan.service.impl.DepartmentServiceImpl;

public class TestHiber {

    private final DepartmentService departmentService = new DepartmentServiceImpl();

    public void test() {
        Long depId = 1L;
        Long empId = 1L;

        departmentService.attachEmployeeToDepartment(depId, empId);
        System.out.println("finish");
    }
}
