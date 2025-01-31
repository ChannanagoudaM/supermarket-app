package com.eidiko.query.service;

import com.eidiko.query.dto.EmployeeDTO;
import com.eidiko.query.dto.EmployeeHierarchyDTO;
import com.eidiko.query.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO getEmployeeById(int id) throws EmployeeNotFoundException;

    List<EmployeeDTO> getAllEmployees();

    EmployeeHierarchyDTO getAllEmployeesHierarchy() throws EmployeeNotFoundException;

    List<Integer> getEmployeeHierarchyById(int id) throws EmployeeNotFoundException;

}
