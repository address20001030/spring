package com.nguyenmauhuy.spring_crud.reponsitory;

import com.nguyenmauhuy.spring_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee,Long> {

}
