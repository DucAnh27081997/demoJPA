package com.example.demojpa.service;

import com.example.demojpa.entity.Company;
import com.example.demojpa.repository.CompanyRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepositoy companyRepositoy;

    @Override
    public List<Company> findAll() {
        return this.companyRepositoy.findAll();
    }

    @Override
    public void save(Company company) {
        companyRepositoy.save(company);
    }

    @Override
    public Company findById(Long Id) {
        return companyRepositoy.findById(Id).get();
    }
}
