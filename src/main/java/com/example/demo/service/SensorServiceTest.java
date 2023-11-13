package com.example.demo.service;


import com.example.demo.model.Measurement;
import com.example.demo.model.MeasurementStatistics;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SensorServiceTest {

    @Mock
    private SensorRepository sensorRepository;

    @Mock
    private MeasurementRepository measurementRepository;

    @InjectMocks
    private SensorService sensorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveMeasurement() {
        Measurement measurement = new Measurement();
        sensorService.saveMeasurement(measurement);
        verify(measurementRepository).save(measurement);
    }

    @Test
    void getMeasurements() {
        Long sensorId = 1L;
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(1);
        sensorService.getMeasurements(sensorId, start, end);
        verify(measurementRepository).findBySensorIdAndTimestampBetween(sensorId, start, end);
    }

}
