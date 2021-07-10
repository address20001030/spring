package com.nguyenmauhuy.spring_crud.mapper.employee;

import com.nguyenmauhuy.spring_crud.entity.Employee;
import com.nguyenmauhuy.spring_crud.mapper.Mapper;
import com.nguyenmauhuy.spring_crud.model.request.employee.employeeSaveRequest;

@org.mapstruct.Mapper(componentModel = "spring")
public interface employeeSaveMapper extends Mapper<Employee, employeeSaveRequest> {
}