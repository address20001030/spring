package com.nguyenmauhuy.spring_crud.model.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class employeeResponse {
    private long id;

    private String userName;

    private String password;
}
