package com.example.demojpa.service;

import com.example.demojpa.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> findAll();
    public void save(Company company);
    public Company findById(Long Id);
}
