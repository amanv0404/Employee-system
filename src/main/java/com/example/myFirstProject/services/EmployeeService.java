package com.example.myFirstProject.services;

import com.example.myFirstProject.exception.DuplicateResourceException;
import com.example.myFirstProject.exception.ErrorResponse;
import com.example.myFirstProject.exception.InvalidCredentialsException;
import com.example.myFirstProject.exception.ResourceNotFoundException;
import com.example.myFirstProject.models.Employee;
import com.example.myFirstProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // create an employee
    public ResponseEntity<Employee> createEmployee(Employee employee){
        // check employee already exist
        if(employeeRepository.existsByEmail(employee.getEmail())){
            throw new DuplicateResourceException("Employee with email "+ employee.getEmail() + "' already exists.");
        }
        // save employee to db
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // get all employees
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> allEmployee = employeeRepository.findAll();
        return  ResponseEntity.status(HttpStatus.OK).body(allEmployee);

    }

    // get employee by id
    public ResponseEntity<?> getEmployeeById(long empId){

        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Employee does not exist with this id"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);

    }

    // update employee by id
    public ResponseEntity<?> updateEmployeeById(long empId,Employee updatedEmployee){

        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Employee not exist with this id"));
        }

        // get employee by id
        Employee existingEmployee = employee.get();

        // update their fields
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());

        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    // delete employee by id
    public ResponseEntity<?> deleteEmployeeById(long empId){
        Optional<Employee> employee = employeeRepository.findById(empId);
        if(employee.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Employee not exist with this id"));
        }
        employeeRepository.deleteById(empId);
        return ResponseEntity.noContent().build();
    }




}
