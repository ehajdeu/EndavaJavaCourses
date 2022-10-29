package com.endava.restraining.dao;

import com.endava.restraining.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends JpaRepository<DepartmentEntity, Long> {
}
