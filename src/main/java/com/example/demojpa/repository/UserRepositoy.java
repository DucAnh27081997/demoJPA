package com.example.demojpa.repository;

import com.example.demojpa.dto.ReportSalaryDto;
import com.example.demojpa.entity.User;
//import com.example.demojpa.repository.impl.UserCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demojpa.dto.ReportSalaryDto;

import java.util.List;

@Repository
public interface UserRepositoy extends JpaRepository<User, String>, JpaSpecificationExecutor<User> { //UserCustomRepository
//    List<User> findAllByNameLike(String name , Pageable pageable);
    Page<User> findAllByNameLike(String name , Pageable pageable);

    @Query("select u from User u where u.name like ?1 and u.hashCode like ?2")
    Page<User> findBy(String name , String hashCode, Pageable pageable);

    @Query(value = "select salary from user  where uuid = :uuid",nativeQuery = true)
    Double getSalaryByUUID(String uuid);

    public static final String SQL_SALARY = "select u.department,sum(u.salary)from user u group by u.department";
    public static final String SQL_SALARY_2 = "select com.example.demojpa.dto.ReportSalaryDto(u.department,sum(u.salary))" +
            "from User u group by u.department";
    @Query(value = SQL_SALARY,nativeQuery = true)
    List<Object[]> salaryTotalOrderByDepartment();

}
