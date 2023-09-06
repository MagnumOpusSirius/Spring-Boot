package com.demo.BootApp.service;

import com.demo.BootApp.dao.EmployeeDao;
import com.demo.BootApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //what if I forget service annotation?
    //we will get null pointer exception
    //why?
    //because we are using EmployeeService object in EmployeeController class


    //we inject the dependency of EmployeeDao into Service class
    //does server start without autowiring?
    //yes, but we will get null pointer exception
    //why?
    //because we are using employeeDao object in saveEmployee method
    @Autowired
    EmployeeDao employeeDao;


    @Override
    public Employee saveEmployee(Employee employee) {
        //save method belongs to JpaRepository
        Employee e = employeeDao.save(employee);
        return e;
    }

    @Override
    public Employee fetchEmployeeById(Integer id) {
        //findById method belongs to JpaRepository
//        Optional<Employee> e = employeeDao.findById(id);
//        if (e.isPresent()) {
//            return e.get();
//        }
//        else {
//            throw new RuntimeException("Employee not found for the id: " + id);
//        }
        //use lambda expression
        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for the id: " + id));
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        //findAll method belongs to JpaRepository
        List<Employee> list = employeeDao.findAll();
        return list;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee e = employeeDao.save(employee);
        return e;
    }
    //is updateEmployee method necessary?
    //no, because saveEmployee method can be used to update as well
    //then why did we create updateEmployee method?
    //because we want to follow the naming convention

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee fetchEmployeeByName(String name) {
        return employeeDao.findByName(name);
    }

    @Override
    public List<Employee> fetchEmployeeBySalary(int salary) {
        return employeeDao.findBySalary(salary);
    }

    @Override
    public Employee fetchEmployeeByPhoneNumber(Integer phoneNumber) {
        return employeeDao.findByPhoneNumber(phoneNumber);
    }


    //where is findByName defined?
    //in EmployeeDao interface
    //where is it implemented?
    //in EmployeeDaoImpl class
}
