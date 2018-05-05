package com.thoughtworks.apple.controller;

import com.thoughtworks.apple.domain.Employee;
import com.thoughtworks.apple.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }
}