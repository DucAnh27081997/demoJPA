package com.example.demojpa.controller;

import com.example.demojpa.dto.ReportSalaryDto;
import com.example.demojpa.entity.User;
import com.example.demojpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/AddAll/{x}")
    public String addAll(@PathVariable int x) {
        userService.addAll(x);
        return "add OK!";
    }

    @GetMapping(value = "/AddAll2/{x}")
    public String addAll2(@PathVariable int x) {
        userService.addAll2(x);
        return "add 2 OK!";
    }

    @GetMapping(value = "/showForTable/{x}")
    public String showForTable(@PathVariable int x) {
        return "showForTable  OK!";
    }

    @GetMapping(value = "/find/name/{name}/hashCode/{hashCode}")
    public List<User> show(@PathVariable String name, @PathVariable String hashCode) {
        return userService.findNameLike(name, hashCode);
    }


    @GetMapping(value = "/find-user")
    public Page<User> findUserBy(@RequestParam(value = "start") int start,
                                 @RequestParam(value = "maxTotal") int maxTotal) {
        return userService.findAll(PageRequest.of(start, maxTotal,
                Sort.by("name").descending()
        ));
    }

    @GetMapping(value = "/find-user-v2")
    public Page<User> findUserByV2(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                   @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) {

        if ("name,hashCode".contains(sortBy)) {
            return userService.findAllByNameLike("%" + name + "%", PageRequest.of(pageNo, pageSize,
                    Sort.by(sortBy).descending()
            ));
        } else return Page.empty();
    }

    @GetMapping(value = "/find-user-v3")
    public Page<User> findUserByV3(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "hashCode") String hashCode,
                                   @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
                                   @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                   @RequestParam(value = "sortBy", defaultValue = "name") String sortBy) {

        if ("name,hashCode".contains(sortBy)) {
            return userService.finAll("%" + name + "%", "%" + hashCode + "%", PageRequest.of(pageNo, pageSize,
                    Sort.by(sortBy).descending()
            ));
        } else return Page.empty();
    }

    @GetMapping(value = "/user/salary/{uuid}")
    public Double getSalaryByUUID(@PathVariable(value = "uuid") String uuid) {
        return userService.getSalaryByUUID(uuid);
    }

    @GetMapping(value = "/salaryTotalOrderByDepartment")
    public List<ReportSalaryDto> salaryTotalOrderByDepartment() {
        return userService.salaryTotalOrderByDepartment();
    }
}
