package com.thymeleaf.crud.service;

import com.thymeleaf.crud.entity.Employee;
import com.thymeleaf.crud.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;

    public void saveOrUpdate(Employee employee) {
        employeeRepo.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.getOne(id);
    }

    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
