package com.example.demojpa.repository;

import com.example.demojpa.entity.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface CompanyRepositoy extends JpaRepository<Company,Long> {
    List<Company> findByName(String name);
}
