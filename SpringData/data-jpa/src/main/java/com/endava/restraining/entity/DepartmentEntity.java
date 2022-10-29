package com.endava.restraining.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class DepartmentEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @OneToMany
    private List<UserEntity> users;
}
