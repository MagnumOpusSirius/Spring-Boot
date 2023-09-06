package com.demo.BootApp.service;

import com.demo.BootApp.model.Employee;

import java.util.List;

//this is the service layer which will be used to interact with the controller
public interface EmployeeService {

    //client will send record and we have to save it in database
    public Employee saveEmployee(Employee employee);

    //client will send id and we have to fetch record from database
    public Employee fetchEmployeeById(Integer id);

    public List<Employee> fetchAllEmployees();

    public Employee updateEmployee(Employee employee);

    public void deleteEmployeeById(Integer id);

    public Employee fetchEmployeeByName(String name);

    public List<Employee> fetchEmployeeBySalary(int salary);

    public Employee fetchEmployeeByPhoneNumber(Integer phoneNumber);

}
