package com.demo.BootApp.controller;

import com.demo.BootApp.model.Employee;
import com.demo.BootApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//its a rest controller class, it can handle web request
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //call interface as it is used to achieve loose coupling
    @Autowired
    EmployeeService employeeService;


    //we want to make it rest api
    //handles GET http method request
    //client can access this REST API with the url: localhost:8080/greet. It will return that string to the client
    @RequestMapping("/greet") // localhost:8080/employees/greet
    public String greeting(){
        return "I want chicken butter masala! Complain to that guy, i want that chicken, you bastard!";
    }
    //why is the below PostMapping not suitable?
    //because we are not sending any data to the server, we are just requesting the server to send some data to us
    @GetMapping("/greet1")
    public String getMessage(){
        return "How are you?";
    }

    //------------------ReceiveObject------------------
    @PostMapping("/save")
    public Employee receiveObject(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    //------------------FetchById------------------
    //Question -> how do I run this?
    //Ans -> localhost:8081/employees/get/{pathVariable}
    @GetMapping("/get/{id}")
    public Employee fetchById(@PathVariable int id){
        //return employeeService.fetchEmployeeById(id);
        return new ResponseEntity<Employee>(employeeService.fetchEmployeeById(id), HttpStatus.OK).getBody();
    }

    //------------------FetchAll------------------
    @GetMapping("/getAll")
    public List<Employee> fetchAll(){
        return employeeService.fetchAllEmployees();
    }

    //------------------Update------------------

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    //------------------Delete------------------
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }

    //------------------FetchByName------------------
    //write the code for fetchByName method
    @GetMapping("/getByName/{name}")
    public Employee fetchByName(@PathVariable String name){
        return employeeService.fetchEmployeeByName(name);
    }

    //------------------FetchBySalary------------------
    //write the code for fetchBySalary method
// make it get 2 results
//    @GetMapping("/getBySalary/{salary}")
//    public List<Employee> fetchBySalary(@PathVariable int salary){
//        return employeeService.fetchEmployeeBySalary(salary);
//    }
    @GetMapping("/getBySalary/{salary}")
    public List<Employee> fetchBySalary(@PathVariable int salary){
        return employeeService.fetchEmployeeBySalary(salary);
    }

    //------------------FetchByPhoneNumber------------------
    //write the code for fetchByPhoneNumber method
    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public Employee fetchByPhoneNumber(@PathVariable Integer phoneNumber){
        return employeeService.fetchEmployeeByPhoneNumber(phoneNumber);
    }




    //create a rest API which returns JAVA bean as a response in the JSON format
    //spring MVC internally uses Jackson library and message converts to convert java object into json

    //@RequestBody converts Java object into JSON body
    @PostMapping("/testEmp")
    public Employee createEmployee(@RequestBody Employee employee){
        // Display employee record on console
        System.out.println("Received Employee:");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Phone Number: " + employee.getPhoneNumber());

        return employee;
    }
}
