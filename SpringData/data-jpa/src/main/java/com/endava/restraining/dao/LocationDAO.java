package com.endava.restraining.dao;

import com.endava.restraining.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationDAO extends JpaRepository<LocationEntity, Long> {
    
    @Query(value = "select * from location_entity where city is null", nativeQuery = true)
    List<LocationEntity> findLocationsWithNullValuesForCity();
    
}
