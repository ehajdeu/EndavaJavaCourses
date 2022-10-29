package com.endava.restraining.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private Integer age;
    
    @OneToOne
    private WorkplaceEntity workplace;
    
}
