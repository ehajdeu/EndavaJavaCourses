package com.endava.restraining.entity;

import javax.persistence.*;

@Entity
public class OfficeEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private LocationEntity location;
}
