package com.example.demo.service;

import com.example.demo.model.Measurement;
import com.example.demo.model.MeasurementStatistics;
import com.example.demo.repository.MeasurementRepository;
import com.example.demo.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    public void saveMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public List<Measurement> getMeasurements(Long sensorId, LocalDateTime start, LocalDateTime end) {
        return measurementRepository.findBySensorIdAndTimestampBetween(sensorId, start, end);
    }

    public MeasurementStatistics calculateStats(Long sensorId, LocalDateTime start, LocalDateTime end) {
        List<Measurement> measurements = measurementRepository.findBySensorIdAndTimestampBetween(sensorId, start, end);

        MeasurementStatistics stats = new MeasurementStatistics();
        if (!measurements.isEmpty()) {
            stats.setMinTemperature(measurements.stream().mapToDouble(Measurement::getTemperature).min().orElse(0));
            stats.setMaxTemperature(measurements.stream().mapToDouble(Measurement::getTemperature).max().orElse(0));
            stats.setSumTemperature(measurements.stream().mapToDouble(Measurement::getTemperature).sum());
            stats.setAvgTemperature(measurements.stream().mapToDouble(Measurement::getTemperature).average().orElse(0));
            stats.setMinHumidity(measurements.stream().mapToDouble(Measurement::getHumidity).min().orElse(0));
            stats.setMaxHumidity(measurements.stream().mapToDouble(Measurement::getHumidity).max().orElse(0));
            stats.setSumHumidity(measurements.stream().mapToDouble(Measurement::getHumidity).sum());
            stats.setAvgHumidity(measurements.stream().mapToDouble(Measurement::getHumidity).average().orElse(0));
        }
        return stats;
    }
}
