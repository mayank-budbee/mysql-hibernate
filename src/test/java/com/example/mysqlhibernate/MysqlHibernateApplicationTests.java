package com.example.mysqlhibernate;

import com.example.mysqlhibernate.model.Employee;
import com.example.mysqlhibernate.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MysqlHibernateApplicationTests {

    @Autowired
    private EmployeeService employeeService;
    @Test
    void getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        log.info("Employee count: {}", employees.size());
        Assertions.assertEquals(1, employees.size());
    }

    @Test
    void findEmployeeById() {
        Employee employee = employeeService.getEmployeeById(1);
        Assertions.assertEquals("raj", employee.getName());
    }
}
