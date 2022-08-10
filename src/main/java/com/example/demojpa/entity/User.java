package com.example.demojpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" ,strategy = "uuid2")
    @Column(name = "UUID")
    private String id;

    @Column(name = "AUTHOR_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private AuthorStatus status;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HASH_CODE", unique = true)
    private String hashCode;

}
