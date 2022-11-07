package com.endava.restraining.rest;

import com.endava.restraining.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.endava.restraining.utils.LocationTestUtils.LOCATION_DTO_ONE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LocationRestController.class)
public class LocationRestControllerTest extends BaseController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    @Test
    void getAllLocationsTest() throws Exception {
        when(locationService.getAll(any(Long.class))).thenReturn(Collections.singletonList(LOCATION_DTO_ONE));

        mockMvc.perform(get("/location/")
                        .param("limit", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(
                        Collections.singletonList(LOCATION_DTO_ONE))));

        verify(locationService).getAll(any(Long.class));
    }

    @Test
    void addNewLocationTest() throws Exception {
        doNothing().when(locationService).add(LOCATION_DTO_ONE);
        mockMvc.perform(post("/location/add")
                        .content(createRequest(LOCATION_DTO_ONE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        verify(locationService).add(LOCATION_DTO_ONE);
    }

    @Test
    void addNewLocationThrowsExceptionTest() throws Exception {
        doThrow(RuntimeException.class).when(locationService).add(LOCATION_DTO_ONE);

        mockMvc.perform(post("/location/add")
                        .content(createRequest(LOCATION_DTO_ONE))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
