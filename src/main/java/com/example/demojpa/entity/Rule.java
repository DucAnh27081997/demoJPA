package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rule")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    @Id
    @JsonIgnore
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "NAME_RULE")
    private String name;

    // mapper tro den bien rules trong Address
    @ManyToMany(mappedBy = "rules")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<User> users;
}
