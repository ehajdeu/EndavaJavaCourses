package com.endava.restraining.utils;

import com.endava.restraining.entity.LocationEntity;
import com.endava.restraining.entity.dto.LocationDto;

import static com.endava.restraining.TestConstants.*;

public class LocationTestUtils {
    public static final LocationDto LOCATION_DTO_ONE = LocationDto.builder()
            .id(ID_ONE)
            .city(CITY_ONE)
            .country(COUNTRY_ONE)
            .build();

    public static final LocationEntity LOCATION_ENTITY_ONE = LocationEntity.builder()
            .id(ID_ONE)
            .city(CITY_ONE)
            .country(COUNTRY_ONE)
            .build();
}
