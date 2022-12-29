package com.example.crud.entity;

import javax.persistence.*;

@Entity
@Table(name = "EmployeeRecord", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Employee {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 15, name = "employee_name")
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
