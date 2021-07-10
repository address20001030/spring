package com.nguyenmauhuy.spring_crud.service;

import com.nguyenmauhuy.spring_crud.entity.Employee;
import com.nguyenmauhuy.spring_crud.model.request.employee.employeeSaveRequest;
import com.nguyenmauhuy.spring_crud.model.response.employeeResponse;

import java.util.List;

public interface employeeService {

    void save(employeeSaveRequest saveRequest);

    void deleteById(long id);

    employeeResponse findById(long id);

    List<Employee> findAll();

    void update(long id, employeeSaveRequest updateRequest);




}
