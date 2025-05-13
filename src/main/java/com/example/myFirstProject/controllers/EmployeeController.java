
package com.example.myFirstProject.controllers;


import com.example.myFirstProject.exception.ErrorResponse;
import com.example.myFirstProject.models.Employee;
import com.example.myFirstProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployee(@RequestParam(required = false) Long id){
        // if id is given then we will fetch by id
        if(id != null){
            return service.getEmployeeById(id);
        }else{
            // if id is not given then we will fetch all employee
            return  service.getAllEmployees();
        }

    }

    @GetMapping("/{empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int empId){
        return service.getEmployeeById(empId);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<?> updateEmployee(@PathVariable int empId,@RequestBody Employee employee){
        return service.updateEmployeeById(empId,employee);
    }

    @DeleteMapping("/{empId}")
    public ResponseEntity<?>  deleteEmployee(@PathVariable int empId){
        return service.deleteEmployeeById(empId);
    }

}
