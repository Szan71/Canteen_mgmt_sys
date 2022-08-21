package com.example.demo.customer;

import javax.persistence.*;
@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String department;
    private Integer employeeId;

    public Customer(){}

    public Customer(Long id, String name, String email, String department, Integer employeeId){
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.employeeId = employeeId;
    }

    public Customer(String name, String email, String department, Integer employeeId){
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }


}
