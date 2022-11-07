package com.endava.restraining.service;

import com.endava.restraining.dao.DepartmentDAO;
import com.endava.restraining.dao.LocationDAO;
import com.endava.restraining.dao.UserDAO;
import com.endava.restraining.entity.LocationEntity;
import com.endava.restraining.entity.dto.LocationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.endava.restraining.utils.LocationTestUtils.LOCATION_DTO_ONE;
import static com.endava.restraining.utils.LocationTestUtils.LOCATION_ENTITY_ONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class LocationServiceTest {
    @Mock
    private LocationDAO locationDAO;

    @Mock
    private DepartmentDAO departmentDAO;

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    LocationService locationService;

    @Test
    void getAllTest() throws Exception {
        //given
        List<LocationDto> expectedList = Collections.singletonList(LOCATION_DTO_ONE);

        //when
        when(locationDAO.findAll()).thenReturn(Collections.singletonList(LOCATION_ENTITY_ONE));

        List<LocationDto> actualList1 = locationService.getAll(null);
        List<LocationDto> actualList2 = locationService.getAll(2L);

        //then

//        assertEquals(expectedList, actualList1);
//        assertEquals(expectedList, actualList2);

        assertAll(
                () -> assertEquals(expectedList, actualList1),
                () -> assertEquals(expectedList, actualList2)
        );
    }

    @Test
    @DisplayName("Should add a new location")
    void addTest() {
        when(locationDAO.save(any(LocationEntity.class))).thenReturn(LOCATION_ENTITY_ONE);

        locationService.add(LOCATION_DTO_ONE);

        ArgumentCaptor<LocationEntity> locationArgumentCaptor =
                ArgumentCaptor.forClass(LocationEntity.class);

        verify(locationDAO, times(1)).
                save(locationArgumentCaptor.capture());

        LocationEntity capturedLocation = locationArgumentCaptor.getValue();

        assertAll(
                () -> assertEquals(capturedLocation.getCity(), LOCATION_DTO_ONE.getCity()),
                () -> assertEquals(capturedLocation.getCountry(), LOCATION_DTO_ONE.getCountry())
        );
    }

    @Test
    void getAllThrowsExceptionTest() {
        when(locationDAO.findAll()).thenReturn(Collections.singletonList(LOCATION_ENTITY_ONE));
        assertThrows(Exception.class, () -> locationService.getAll(-2L));
    }
}

