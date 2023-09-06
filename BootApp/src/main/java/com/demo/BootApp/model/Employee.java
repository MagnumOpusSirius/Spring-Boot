package com.demo.BootApp.model;

import javax.persistence.*;

@Entity
@Table(name = "my_employee")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer salary;
    private Integer phoneNumber;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer salary, Integer phoneNumber) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
