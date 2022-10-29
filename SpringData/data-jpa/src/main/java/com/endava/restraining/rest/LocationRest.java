package com.endava.restraining.rest;

import com.endava.restraining.entity.dto.LocationDto;
import com.endava.restraining.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/location")
public class LocationRest {
    
    private final LocationService locationService;
    
    @PostMapping("/add")
    public ResponseEntity<Object> addNewLocation(@RequestBody LocationDto locationDto) {
        try {
            locationService.add(locationDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> getAllLocations(@RequestParam(required = false) Long limit) {
        try {
            return new ResponseEntity<>(locationService.getAll(limit), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable Long id) {
        try {
            locationService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        try {
            locationService.update(id, locationDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/nocity")
    public ResponseEntity<Object> getNoCityLocations() {
        try {
            return new ResponseEntity<>(locationService.findNoCityLocationsIds(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
