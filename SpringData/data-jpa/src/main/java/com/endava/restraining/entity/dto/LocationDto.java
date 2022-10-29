package com.endava.restraining.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String city;
    private String country;
}
