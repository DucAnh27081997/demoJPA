package com.example.demojpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADDRESS")
    private Long id;

    @Column(name = "NAME_ADDRESS")
    private String nameAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public Address(Long id, String nameAddress) {
        this.id = id;
        this.nameAddress = nameAddress;
    }
    public Address(){

    }
}
