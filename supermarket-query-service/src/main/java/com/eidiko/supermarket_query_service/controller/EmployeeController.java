package com.eidiko.supermarket_query_service.controller;

import com.eidiko.supermarket_query_service.dto.EmployeeDTO;
import com.eidiko.supermarket_query_service.exception.EmployeeNotFoundException;
import com.eidiko.supermarket_query_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
