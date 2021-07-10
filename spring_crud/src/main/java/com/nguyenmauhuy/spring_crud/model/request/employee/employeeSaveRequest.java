package com.nguyenmauhuy.spring_crud.model.request.employee;

import lombok.Data;

import javax.persistence.Column;

@Data
public class employeeSaveRequest {
    private String userName;
    private String password;
    private String name;
    private String sex;
    private String email;
    private String phone;
    private String address;
}
