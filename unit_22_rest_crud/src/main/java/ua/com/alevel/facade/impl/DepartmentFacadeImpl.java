package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.req.DepartmentReqDto;
import ua.com.alevel.dto.res.DepartmentResDto;
import ua.com.alevel.entity.Department;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
public class DepartmentFacadeImpl implements DepartmentFacade {

    private final DepartmentService departmentService;

    public DepartmentFacadeImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void create(DepartmentReqDto departmentReqDto) {
        Department department = new Department();
        department.setName(departmentReqDto.getName());
        departmentService.save(department);
    }

    @Override
    public void update(DepartmentReqDto departmentReqDto, Long id) {
        Department department = departmentService.findById(id);
        department.setName(departmentReqDto.getName());
        departmentService.update(department);
    }

    @Override
    public void delete(Long id) {
        departmentService.delete(id);
    }

    @Override
    public DepartmentResDto findById(Long id) {
        return new DepartmentResDto(departmentService.findById(id));
    }

    @Override
    public Collection<DepartmentResDto> findAll() {
        return departmentService.findAll().stream().map(DepartmentResDto::new).toList();
    }
}
