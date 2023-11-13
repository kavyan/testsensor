package com.example.demo.controller;

import com.example.demo.model.Measurement;
import com.example.demo.model.MeasurementStatistics;
import com.example.demo.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping("/measurements")
    public void addMeasurement(@RequestBody Measurement measurement) {
        sensorService.saveMeasurement(measurement);
    }

    @GetMapping("/measurements")
    public List<Measurement> getMeasurements(@RequestParam Long sensorId,
                                             @RequestParam(required = false) LocalDateTime start,
                                             @RequestParam(required = false) LocalDateTime end) {
        return sensorService.getMeasurements(sensorId, start, end);
    }

    @GetMapping("/measurements/stats")
    public ResponseEntity<MeasurementStatistics> getMeasurementsStats(@RequestParam Long sensorId,
                                                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                                                      @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        MeasurementStatistics stats = sensorService.calculateStats(sensorId, start, end);
        return ResponseEntity.ok(stats);
    }
}
