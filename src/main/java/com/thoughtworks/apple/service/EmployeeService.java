package com.thoughtworks.apple.service;

import com.thoughtworks.apple.domain.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmployeeService {

    private Map<Long, Employee> employeeMap;
    private Long nextId;

    @PostConstruct
    public void initEmployeeList() {
        employeeMap = Collections.synchronizedMap(new TreeMap<>(Comparator.comparingLong(key -> key)));
        nextId = 0L;

        Long id = getNextId();
        employeeMap.put(id,
                new Employee.Builder()
                        .setId(id)
                        .setName("小明")
                        .setAge(20)
                        .setGender("男")
                        .build());

        id = getNextId();
        employeeMap.put(id,
                new Employee.Builder()
                        .setId(id)
                        .setName("小红")
                        .setAge(19)
                        .setGender("女")
                        .build());

        id = getNextId();
        employeeMap.put(id,
                new Employee.Builder()
                        .setId(id)
                        .setName("小智")
                        .setAge(15)
                        .setGender("男")
                        .build());

        id = getNextId();
        employeeMap.put(id,
                new Employee.Builder()
                        .setId(id)
                        .setName("小刚")
                        .setAge(16)
                        .setGender("男")
                        .build());

        id = getNextId();
        employeeMap.put(id,
                new Employee.Builder()
                        .setId(id)
                        .setName("小霞")
                        .setAge(15)
                        .setGender("女")
                        .build());
    }

    private Long getNextId() {
        return nextId++;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployee(Long id) {
        return employeeMap.get(id);
    }

    public Employee saveEmployee(Employee employee) {
        Long id = getNextId();
        employee.setId(id);
        employeeMap.put(id, employee);
        return employee;
    }
}