package com.endava.restraining.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class DisciplineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    
    @OneToMany
    private List<DepartmentEntity> departmentEntityList;
}
