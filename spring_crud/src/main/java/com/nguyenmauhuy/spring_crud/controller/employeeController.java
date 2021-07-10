package com.nguyenmauhuy.spring_crud.controller;


import com.nguyenmauhuy.spring_crud.mapper.employee.employeeResponseMapper;
import com.nguyenmauhuy.spring_crud.mapper.employee.employeeSaveMapper;
import com.nguyenmauhuy.spring_crud.model.request.employee.employeeSaveRequest;
import com.nguyenmauhuy.spring_crud.model.response.employeeResponse;
import com.nguyenmauhuy.spring_crud.service.employeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class employeeController {
    private final employeeService employeeService;
    private final employeeSaveMapper employeeSaveMapper;
    private final employeeResponseMapper employeeResponseMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<employeeResponse>> findAll(){
        return ResponseEntity.ok(employeeResponseMapper.to(employeeService.findAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> create(@RequestBody employeeSaveRequest saveRequest){
        employeeService.save(saveRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<employeeResponse> getId(@PathVariable long id){
        employeeResponse employee = employeeService.findById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable long id,@RequestBody employeeSaveRequest saveRequest){
        employeeService.update(id,saveRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        employeeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
