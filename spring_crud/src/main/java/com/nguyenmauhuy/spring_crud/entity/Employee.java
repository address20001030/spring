package com.nguyenmauhuy.spring_crud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String sex;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String address;
}
