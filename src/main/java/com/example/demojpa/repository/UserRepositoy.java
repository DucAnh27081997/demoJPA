package com.example.demojpa.repository;

import com.example.demojpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepositoy extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
//    List<User> findAllByNameLike(String name , Pageable pageable);
    Page<User> findAllByNameLike(String name , Pageable pageable);

    @Query("select u from User u where u.name like ?1 and u.hashCode like ?2")
    Page<User> findBy(String name , String hashCode, Pageable pageable);
}
