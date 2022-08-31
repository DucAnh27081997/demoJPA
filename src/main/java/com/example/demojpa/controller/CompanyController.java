package com.example.demojpa.controller;

import com.example.demojpa.entity.Company;
import com.example.demojpa.entity.Employee;
import com.example.demojpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/company/")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    List<Company> findAll() {
        return companyService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        try {
            Company com = new Company();
            com.setName("Vatek");

            Employee e1 = new Employee("ducla", "113");
            Employee e2 = new Employee("ducla2", "114");

            List<Employee> employees = new ArrayList<>();
            employees.add(e1);
            employees.add(e2);

            com.setEmployees(employees);
//            e1.setCompany(com);
//            e2.setCompany(com);

            companyService.save(com);

        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "add OK";
    }

    @RequestMapping(value = "/add-company-2", method = RequestMethod.PUT)
    public String add(@RequestBody Company company) {
        try {
            companyService.save(company);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "add company OK";
    }

    @RequestMapping(value = "/add-company", method = RequestMethod.GET)
    public String addCompany() {
        try {
            Company com = new Company();
            com.setName("Vatek company");
            com.setEmployees(null);
            companyService.save(com);

        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "add OK";
    }

    @RequestMapping(value = "/add-employee/{id}", method = RequestMethod.GET)
    public String add(@PathVariable(name = "id") Long id) {
        try {
            Company com = companyService.findById(id);
            List<Employee> employees = new ArrayList<>();
            Employee em1 = new Employee("Cao Tuan Tai", "113");
            Employee em2 = new Employee("Cao Tuan Tai 2", "12222222");
            employees.add(em1);
            employees.add(em2);
            com.setEmployees(employees);
//            em1.setCompany(com);
//            em2.setCompany(com);
            companyService.save(com);

        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "add employee OK";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
