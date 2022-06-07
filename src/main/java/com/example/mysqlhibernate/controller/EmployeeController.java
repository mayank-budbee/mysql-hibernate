package com.example.mysqlhibernate.controller;

import com.example.mysqlhibernate.model.Employee;
import com.example.mysqlhibernate.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEMployeeById(@PathVariable("id") Integer employeeId){
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> getEMployeeById(@PathVariable("id") Integer employeeId,
                                                    @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, employeeId),
            HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(String.format("Employee %s deleted successfully", employeeId),
            HttpStatus.OK);
    }
}
