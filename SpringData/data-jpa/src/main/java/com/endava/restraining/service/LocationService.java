package com.endava.restraining.service;

import com.endava.restraining.dao.DepartmentDAO;
import com.endava.restraining.dao.LocationDAO;
import com.endava.restraining.dao.UserDAO;
import com.endava.restraining.entity.DepartmentEntity;
import com.endava.restraining.entity.LocationEntity;
import com.endava.restraining.entity.UserEntity;
import com.endava.restraining.entity.dto.LocationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {
    
    private final LocationDAO locationDAO;
    
    private final DepartmentDAO departmentDAO;
    
    private final UserDAO userDAO;

    public void add(LocationDto locationDto) {
        LocationEntity location = new LocationEntity();
        location.setCity(locationDto.getCity());
        location.setCountry(locationDto.getCountry());
        locationDAO.save(location);
    }

    public List<LocationDto> getAll(Long limit) throws Exception {
        List<LocationDto> locations = new ArrayList<>();
        List<LocationEntity> daoLocations = locationDAO.findAll();
        if (limit != null) {
            if (limit < 0) {
                throw new Exception("Limit is negative!");
            }
            for (int i=0; i<limit; i++) {
                LocationDto location = new LocationDto();
                location.setId(daoLocations.get(i).getId());
                location.setCity(daoLocations.get(i).getCity());
                location.setCountry(daoLocations.get(i).getCountry());
                locations.add(location);
                if (i == daoLocations.size()-1) {
                    break;
                }
            }
        } else {
            for (LocationEntity daoLocation : daoLocations) {
                LocationDto location = new LocationDto();
                location.setId(daoLocation.getId());
                location.setCountry(daoLocation.getCountry());
                location.setCity(daoLocation.getCity());
                locations.add(location);
            }
        }
        return locations;
    }

    public void delete(Long id) {
        locationDAO.deleteById(id);
    }

    public void update(Long id, LocationDto locationDto) {
        LocationEntity location = locationDAO.getById(id);
        location.setCountry(locationDto.getCountry());
        location.setCity(locationDto.getCity());
        locationDAO.save(location);
    }
    
    public void assign(Long userId, Long departmentId) {
        DepartmentEntity departmentEntity = departmentDAO.getById(departmentId);
        UserEntity userEntity = userDAO.getById(userId);
        if (departmentEntity.getUsers() == null) {
            departmentEntity.setUsers(new ArrayList<>());
        }
        departmentEntity.getUsers().add(userEntity);
        departmentDAO.save(departmentEntity);
    }
    
    public List<Long> findNoCityLocationsIds() {
        List<LocationEntity> locationEntities = locationDAO.findLocationsWithNullValuesForCity();
        List<Long> result = new ArrayList<>();
        for (LocationEntity location : locationEntities) {
            result.add(location.getId());
        }
        return result;
    }
}
