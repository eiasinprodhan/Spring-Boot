package com.emranhss.project.service;

import com.emranhss.project.entity.Employee;
import com.emranhss.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void update(Employee employee) {
        employeeRepository.save(employee);
    }


}
