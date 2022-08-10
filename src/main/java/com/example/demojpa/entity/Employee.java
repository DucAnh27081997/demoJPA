package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @Column(name = "ID_COMPANY")
//    private Long idCompany;

    @Column(name = "NAME_EMPLOYEE")
    private String nameEmployee;

    @Column(name = "PHONE")
    private String phone;

    //@OneToOne
    //@JoinColumn(name = "ID_COMPANY", nullable = false, referencedColumnName = "ID_COMPANY")
//    @JsonBackReference
//    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLOYEE", nullable = false, referencedColumnName = "ID")
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Employee(String nameEmployee, String phone) {
        this.nameEmployee = nameEmployee;
        this.phone = phone;
    }

    public Employee() {
    }

}
