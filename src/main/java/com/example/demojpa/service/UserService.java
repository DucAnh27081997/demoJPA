package com.example.demojpa.service;

import com.example.demojpa.dto.ReportSalaryDto;
import com.example.demojpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public Page<User> findAll(Pageable pageable);
    public Page<User> findAllByNameLike(String name, Pageable pageable);
    public Page<User> finAll(String name,String hashCode, Pageable pageable);
    public Double getSalaryByUUID(String uuid);
    public List<ReportSalaryDto> salaryTotalOrderByDepartment();
    public void addAll(int x);
    public void addAll2(int x);
    public List<User> findNameLike(String name, String hashCode);
}
