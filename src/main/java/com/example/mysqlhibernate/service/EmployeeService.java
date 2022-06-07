package com.example.mysqlhibernate.service;

import com.example.mysqlhibernate.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee>  getAllEmployees();

    Employee getEmployeeById(Integer id);

    Employee updateEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);
}
