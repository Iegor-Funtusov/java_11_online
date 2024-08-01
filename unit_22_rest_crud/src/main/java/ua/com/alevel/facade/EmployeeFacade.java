package ua.com.alevel.facade;

import ua.com.alevel.dto.req.EmployeeReqDto;
import ua.com.alevel.dto.res.EmployeeResDto;

public interface EmployeeFacade extends CrudFacade<EmployeeReqDto, EmployeeResDto> { }
