package com.example.mysqlhibernate.service.impl;

import com.example.mysqlhibernate.exception.ResourceNotFoundException;
import com.example.mysqlhibernate.model.Employee;
import com.example.mysqlhibernate.repository.EmployeeRepository;
import com.example.mysqlhibernate.service.EmployeeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else{
//            throw new ResourceNotFoundException("Employee", "id", id.toString());
//        }
        return employeeRepository.findById(id).orElseThrow(() ->
             new  ResourceNotFoundException("Employee", "id", id.toString()));
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
            new  ResourceNotFoundException("Employee", "id", id.toString()));

        existingEmployee.setName(employee.getName());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDeptId(employee.getDeptId());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.findById(id).orElseThrow(() ->
            new  ResourceNotFoundException("Employee", "id", id.toString()));

        employeeRepository.deleteById(id);
    }
}
