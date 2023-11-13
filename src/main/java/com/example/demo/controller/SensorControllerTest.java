package com.example.demo.controller;

import com.example.demo.model.Measurement;
import com.example.demo.model.MeasurementStatistics;
import com.example.demo.service.SensorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SensorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SensorService sensorService;

    @InjectMocks
    private SensorController sensorController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(sensorController).build();
    }

    @Test
    void addMeasurement() throws Exception {
        Measurement measurement = new Measurement();
        mockMvc.perform(post("/api/sensors/measurements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(measurement)))
                .andExpect(status().isOk());
    }

    @Test
    void getMeasurements() throws Exception {
        Long sensorId = 1L;
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(1);
        List<Measurement> measurements = Arrays.asList(new Measurement());

        given(sensorService.getMeasurements(sensorId, start, end)).willReturn(measurements);

        mockMvc.perform(get("/api/sensors/measurements")
                        .param("sensorId", sensorId.toString())
                        .param("start", start.toString())
                        .param("end", end.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }

    @Test
    void getMeasurementsStats() throws Exception {
        Long sensorId = 1L;
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(1);
        MeasurementStatistics stats = new MeasurementStatistics();

        given(sensorService.calculateStats(sensorId, start, end)).willReturn(stats);

        mockMvc.perform(get("/api/sensors/measurements/stats")
                        .param("sensorId", sensorId.toString())
                        .param("start", start.toString())
                        .param("end", end.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
