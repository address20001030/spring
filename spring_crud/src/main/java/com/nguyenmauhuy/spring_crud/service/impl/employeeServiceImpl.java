package com.nguyenmauhuy.spring_crud.service.impl;

import com.nguyenmauhuy.spring_crud.entity.Employee;
import com.nguyenmauhuy.spring_crud.exception.ObjectNotFoundException;
import com.nguyenmauhuy.spring_crud.mapper.employee.employeeResponseMapper;
import com.nguyenmauhuy.spring_crud.mapper.employee.employeeSaveMapper;
import com.nguyenmauhuy.spring_crud.model.request.employee.employeeSaveRequest;
import com.nguyenmauhuy.spring_crud.model.response.employeeResponse;
import com.nguyenmauhuy.spring_crud.reponsitory.employeeRepository;
import com.nguyenmauhuy.spring_crud.service.employeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class employeeServiceImpl implements employeeService {
    private final employeeRepository employeeRepository;
    private final employeeResponseMapper employeeResponseMapper;
    private final employeeSaveMapper employeeSaveMapper;


    @Override
    public void save(employeeSaveRequest saveRequest) {
        Employee employee = employeeSaveMapper.to(saveRequest);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public employeeResponse findById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        employee.orElseThrow(()->new ObjectNotFoundException("employee not found"));
        return employeeResponseMapper.to(employee.get());
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void update(long id, employeeSaveRequest updateRequest) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee updateData = employee.get();
        updateData.setUserName(updateRequest.getUserName());
        updateData.setPassword(updateRequest.getPassword());
        updateData.setName(updateRequest.getName());
        updateData.setSex(updateRequest.getSex());
        updateData.setPhone(updateRequest.getPhone());
        updateData.setEmail(updateRequest.getEmail());
        updateData.setAddress(updateRequest.getAddress());

        employeeRepository.save(updateData);
    }
}
