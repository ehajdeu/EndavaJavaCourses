package com.endava.restraining.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WorkplaceEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity office;
    
    private Integer floor;

}
