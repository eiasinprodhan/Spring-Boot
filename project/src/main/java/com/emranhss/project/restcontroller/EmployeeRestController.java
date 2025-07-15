package com.emranhss.project.restcontroller;

import com.emranhss.project.entity.Employee;
import com.emranhss.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeRestController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @DeleteMapping
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


}
