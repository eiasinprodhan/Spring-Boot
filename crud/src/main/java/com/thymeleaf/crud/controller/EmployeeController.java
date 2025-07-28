package com.thymeleaf.crud.controller;

import com.thymeleaf.crud.entity.Employee;
import com.thymeleaf.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("")
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "home";
    }

    @GetMapping("/employee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new  Employee());
        return "employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveOrUpdate(employee);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String editEmployee(Model model, @PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/";
    }
}
