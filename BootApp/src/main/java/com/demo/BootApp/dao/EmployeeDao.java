package com.demo.BootApp.dao;

import com.demo.BootApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//this does session.save(), session.get(), session.delete() and session.update()
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
    Employee findByName(String name);
    List<Employee> findBySalary(int salary);
    Employee findByPhoneNumber(Integer phoneNumber);


}
