package com.example.mysqlhibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
//    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "ROLE", length = 45)
    private String role;

    @Column(name = "dept_id")
    private Integer deptId;

}